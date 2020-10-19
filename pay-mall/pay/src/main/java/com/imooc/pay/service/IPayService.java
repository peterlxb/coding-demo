package com.imooc.pay.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

/**
 * Created By Peter Liu
 * */
public interface IPayService {

    /**
     * 创建/发起 支付
     * */
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum payType);

    /**
     * 异步通知处理接口
     * */
    String asyncNotify(String notifyDate);
}
