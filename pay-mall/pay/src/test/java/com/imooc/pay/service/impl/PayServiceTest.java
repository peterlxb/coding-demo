package com.imooc.pay.service.impl;

import com.imooc.pay.PayApplicationTests;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private PayService payService;

    @Test
    public void create() {
        payService.create("426344545454", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }

}