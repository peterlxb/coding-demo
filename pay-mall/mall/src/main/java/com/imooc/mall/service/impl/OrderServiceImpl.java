package com.imooc.mall.service.impl;

import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.dao.ShippingMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.pojo.Cart;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.pojo.Shipping;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created By Peter Liu
 * 2020-10-30
 * */
@Service
public class OrderServiceImpl implements IOrderService {
    
    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private ICartService cartService;

    @Autowired
    ProductMapper productMapper;
    
    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {

        // 收货地址shipping 校验
        Shipping shippings = shippingMapper.selectByUidAndShippingId(uid,shippingId);
        if (shippings == null) {
            return ResponseVo.error(ResponseEnum.SHIPPING_NOT_EXIST);
        }

        // 获取购物车(检验商品状态，库存)
        List<Cart> cartList = cartService.listForCart(uid).stream()
                .filter(Cart::getProductSelected)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(cartList)) {
            return ResponseVo.error(ResponseEnum.CART_PRODUCT_NOT_EXIST);
        }

        // 获取cartList 里的 productId
        Set<Integer> productIdSet = cartList.stream()
                .map(Cart::getProductId)
                .collect(Collectors.toSet());

        // 避免在循环里面嵌套查询数据库
        List<Product> productList = productMapper.selectByProductIdSet(productIdSet);
        Map<Integer, Product> map = productList.stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        for (Cart cart: cartList) {
            // 根据 productId 查询数据库
            Product product = map.get(cart.getProductId());

            // 是否有商品
            if (product == null) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST,
                        "商品不存在. productId =" + cart.getProductId());
            }

            // 库存是否充足
            if (product.getStock() < cart.getQuantity()) {
                return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST,
                        "库存不正确. " + product.getName());
            }
        }



        // 计算总价(选中商品)

        // 生成订单 入库(order和orderItem 需要同时生成才生效) 用到事物

        // 减库存

        // 更新购物车(选中商品)

        // 构造 orderVo
        return null;
    }
}
