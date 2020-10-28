package com.imooc.mall.service.impl;

import com.google.gson.Gson;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.pojo.Cart;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.vo.CartProductVo;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created By Peter Liu
 * */
@Service
public class CartServiceImpl implements ICartService {

    private final static String CART_REDIS_KEY_TEMPLATE = "cart_%d";

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();

    @Override
    public ResponseVo<CartVo> add(Integer uid,CartAddForm form) {
        // 每次新增常量
        Integer quantity = 1;
        Product product = productMapper.selectByPrimaryKey(form.getProductId());

        // 判断商品是否存在
        if (product == null) {
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }

        // 商品是否正常在售
        if (product.getStatus().equals(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE.getCode())) {
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }

        // 商品库存是否充足
        if (product.getStock() < 0) {
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }

        // 写入到 redis (使用hash来存储代替list结构)
        // set 接收两个参数
        HashOperations<String, String, String> optsForHash  = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);

        // 从数据库获取数据
        String value = optsForHash.get(redisKey, String.valueOf(product.getId()));

        Cart cart;
        if (StringUtils.isEmpty(value)) {
            // 没有该商品/新增
            cart = new Cart(product.getId(), quantity, form.isSelected());
        } else {
            // 存在先反序列化/加1
            cart = gson.fromJson(value, Cart.class);
            cart.setQuantity(cart.getQuantity() + quantity);
        }

        optsForHash.put(redisKey,
                        String.valueOf(product.getId()),
                        gson.toJson(cart)
                 );

        return list(uid);
    }

    @Override
    public ResponseVo<CartVo> list(Integer uid) {
        HashOperations<String, String, String> optsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);
        Map<String, String> entries = optsForHash.entries(redisKey);

        boolean selectAll = true; // 默认全选
        Integer cartTotalQuantity = 0; // 初始 0
        BigDecimal cartTotalPrice = BigDecimal.ZERO; // 总价
        CartVo cartVo = new CartVo();

        // 构造list
        List<CartProductVo> cartProductVoList = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries.entrySet()) {
            Integer productId = Integer.valueOf(entry.getKey());
            Cart cart = gson.fromJson(entry.getValue(), Cart.class);

            // 优化查询 使用mysql里的in
            Product product = productMapper.selectByPrimaryKey(productId);
            if (product != null) {
                CartProductVo cartProductVo = new CartProductVo(
                        productId,
                        cart.getQuantity(),
                        product.getName(),
                        product.getSubtitle(),
                        product.getMainImage(),
                        product.getPrice(),
                        product.getStatus(),
                        product.getPrice().multiply((BigDecimal.valueOf(cart.getQuantity()))),
                        product.getStock(),
                        cart.getProductSelected()
                );

                cartProductVoList.add(cartProductVo);

                if (!cart.getProductSelected()) {
                    selectAll = false;
                }

                // 计算总价(只计算选中的)
                if (cart.getProductSelected()) {
                    cartTotalPrice = cartTotalPrice.add(cartProductVo.getProductTotalPrice());
                }
            }
            // 总量
            cartTotalQuantity += cart.getQuantity();
        }

        // 有一个没有选中就不是全选
        cartVo.setSelectedAll(selectAll);
        cartVo.setCartTotalQuantity(cartTotalQuantity);
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartProductVoList(cartProductVoList);
        return ResponseVo.success(cartVo);
    }
}
