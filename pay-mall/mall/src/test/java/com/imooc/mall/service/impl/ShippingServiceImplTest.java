package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.service.IShippingService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created By Peter Liu
 * */
@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    private Integer shippingId = 5;

    private ShippingForm form;

    @Before
    public void before() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("PeterLiu");
        form.setReceiverAddress("CODING");
        form.setReceiverCity("深圳");
        form.setReceiverMobile("18812345678");
        form.setReceiverPhone("010123456");
        form.setReceiverProvince("深圳");
        form.setReceiverDistrict("南山区");
        form.setReceiverZip("318052");

        this.form = form;
    }

    @Test
    public void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(1,form);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void update() {
        form.setReceiverCity("杭州");
        form.setReceiverDistrict("滨江");
        form.setReceiverAddress("NET-EASE");
        ResponseVo<Map<String, Integer>> responseVo = shippingService.update(1,6,form);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid,1,10);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}