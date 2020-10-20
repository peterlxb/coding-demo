package com.imooc.pay.confg;

import com.lly835.bestpay.config.AliPayConfig;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BestPayConfig {

    @Autowired
    private WxAccountConfig wxAccountConfig;

    @Autowired
    private AlipayAccountConfig alipayAccountConfig;

    /**
     * 加上Bean注解，项目启动时会执行下面代码,
     * */
    @Bean
    public BestPayService bestPayService(WxPayConfig wxPayConfig) {
        // alipay config
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId(alipayAccountConfig.getAppId());
        aliPayConfig.setPrivateKey(alipayAccountConfig.getPrivateKey());
        aliPayConfig.setAliPayPublicKey(alipayAccountConfig.getPublicKey());
        aliPayConfig.setNotifyUrl(alipayAccountConfig.getNotifyUrl());
        aliPayConfig.setReturnUrl(alipayAccountConfig.getReturnUrl());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        bestPayService.setAliPayConfig(aliPayConfig);
        return bestPayService;
    }

    @Bean
    public WxPayConfig wxPayConfig() {
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(wxAccountConfig.getAppId());
        wxPayConfig.setMchId(wxAccountConfig.getMchId());
        wxPayConfig.setMchKey(wxAccountConfig.getMchKey());

        // 异步回掉地址 -> 可以用云主机IP/报备过的域名
        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());
        wxPayConfig.setReturnUrl(wxAccountConfig.getReturnUrl());

        return wxPayConfig;
    }
}
