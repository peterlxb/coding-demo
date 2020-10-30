package com.imooc.mall.service.impl;

import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;

public class OrderServiceImpl implements IOrderService {


    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {

        // 收货地址shipping 校验

        // 获取购物车(检验商品状态，库存)

        // 计算总价(选中商品)

        // 生成订单 入库(order和orderItem 需要同时生成才生效) 用到事物

        // 减库存

        // 更新购物车(选中商品)

        // 构造 orderVo
        return null;
    }
}
