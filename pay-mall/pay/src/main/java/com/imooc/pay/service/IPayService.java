package com.imooc.pay.service;

import java.math.BigDecimal;

/**
 * Created By Peter Liu
 * */
public interface IPayService {

    /**
     * 创建/发起 支付
     * */
    void create(String orderId, BigDecimal amount);
}
