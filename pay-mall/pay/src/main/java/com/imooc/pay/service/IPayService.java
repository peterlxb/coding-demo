package com.imooc.pay.service;

import com.imooc.pay.pojo.PayInfo;
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

    /**
     * 查询支付记录(通过订单号)
     * @param orderId
     * @return
     * */
    PayInfo queryByOrderId(String orderId);
}
