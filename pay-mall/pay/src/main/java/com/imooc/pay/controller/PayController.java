package com.imooc.pay.controller;

import com.imooc.pay.service.impl.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By peter liu
 * */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 将参数传递到url中，
     * */
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId, @RequestParam("amount") BigDecimal amount) {

        // 第一种将参数写死
        // PayResponse  response = payService.create("1212132344344", BigDecimal.valueOf(0.01));
        PayResponse  response = payService.create(orderId, amount);

        Map map = new HashMap<>();
        map.put("codeUrl", response.getCodeUrl());

        return new ModelAndView("create",map);
    }
}
