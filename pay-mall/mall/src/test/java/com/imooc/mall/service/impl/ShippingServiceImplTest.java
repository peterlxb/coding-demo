package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.service.IShippingService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private  Integer uid = 1;

    @Test
    public void add() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("PeterLiu");
        form.setReceiverAddress("NETEASE");
        form.setReceiverCity("深圳");
        form.setReceiverMobile("18812345678");
        form.setReceiverPhone("010123456");
        form.setReceiverProvince("深圳");
        form.setReceiverDistrict("南山区");
        form.setReceiverZip("318052");

        ResponseVo<Map<String, Integer>> responseVo =  shippingService.add(1,form);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void list() {
    }
}