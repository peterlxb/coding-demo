package com.imooc.pay.service.impl;

import com.imooc.pay.dao.PayInfoMapper;
import com.imooc.pay.enums.PayPlatformEnum;
import com.imooc.pay.pojo.PayInfo;
import com.imooc.pay.service.IPayService;
import com.lly835.bestpay.enums.BestPayPlatformEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.enums.OrderStatusEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PayService implements IPayService {

    /**
     * 将 BestPayService 配置相关代码移到config中，避免重复创建问题
     * */
    @Autowired
    BestPayService bestPayService;

    @Autowired
    PayInfoMapper payInfoMapper;

    /**
     * 创建/发起 支付
     *
     * @param orderId
     * @param amount
     * */
    @Override
    public PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum) {

        // 写入数据库
        PayInfo payInfo = new PayInfo(Long.parseLong(orderId),
                PayPlatformEnum.getByBestPayTypeEnum(bestPayTypeEnum).getCode(),
                OrderStatusEnum.NOTPAY.name(),
                amount);
        payInfoMapper.insertSelective(payInfo);

        PayRequest request = new PayRequest();
        request.setOrderName("1157174-peterLiu");
        request.setOrderId(orderId);
        request.setOrderAmount(amount.doubleValue());
        request.setPayTypeEnum(bestPayTypeEnum);

        PayResponse response =  bestPayService.pay(request);
        log.info("发起支付 response: ", response);

        return response;
    }

    @Override
    public String asyncNotify(String notifyDate) {
        // 1. 签名校验
        PayResponse payResponse = bestPayService.asyncNotify(notifyDate);
        log.info("异步通知 payResponse={}", payResponse);

        // 2. 金额检验(从数据库查订单)
        PayInfo payInfo = payInfoMapper.selectByOrderNo(Long.parseLong((payResponse.getOrderId())));
        if (payInfo == null) {
            // 比较严重错误告警
            throw new RuntimeException("通过orderNo查询到的结果是null");
        }

        // 订单支付状态为已支付(减少冗余代码)
        if (!payInfo.getPlatformStatus().equals(OrderStatusEnum.SUCCESS.name())) {
            // Double 类型比较
            if (payInfo.getPayAmount().compareTo(BigDecimal.valueOf(payResponse.getOrderAmount())) != 0) {
                // warning
                throw new RuntimeException("异步通知中的金额和数据库里的不一致，orderNo="+payResponse.getOrderId());
            }

            // 3. 修改订单支付状态
            payInfo.setPlatformStatus(OrderStatusEnum.SUCCESS.name());
            payInfo.setPlatformNumber(payResponse.getOutTradeNo());
            payInfoMapper.updateByPrimaryKeySelective(payInfo);
        }

        //TODO pay 发送 MQ消息，mall 接收 MQ消息

        if (payResponse.getPayPlatformEnum() == BestPayPlatformEnum.WX) {
            // 4. 通知微信结果(避免重复通知)
            return "<xml>\n" +
                    "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                    "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                    "</xml>";
        } else  if (payResponse.getPayPlatformEnum() == BestPayPlatformEnum.ALIPAY) {
            return "success";
        }

        throw new RuntimeException("异步通知中错误的支付平台");

    }

    @Override
    public PayInfo queryByOrderId(String orderId) {
        return payInfoMapper.selectByOrderNo(Long.parseLong(orderId));
    }
}
