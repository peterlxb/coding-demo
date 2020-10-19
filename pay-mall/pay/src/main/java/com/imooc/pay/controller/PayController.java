package com.imooc.pay.controller;

import com.imooc.pay.service.impl.PayService;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By peter liu
 * */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 将参数传递到url中，
     * */
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("amount") BigDecimal amount,
                               @RequestParam("payType") BestPayTypeEnum bestPayTypeEnum) {

        // 第一种将参数写死
        // PayResponse  response = payService.create("1212132344344", BigDecimal.valueOf(0.01));
        PayResponse  response = payService.create(orderId, amount, bestPayTypeEnum);
        Map<String, String> map = new HashMap<>();

        // 支付方式不同，渲染不同 WX 使用 code_url alipay 使用body
        if (bestPayTypeEnum == BestPayTypeEnum.WXPAY_NATIVE) {
            map.put("codeUrl", response.getCodeUrl());
            return new ModelAndView("createForWxNative",map);
        } else if (bestPayTypeEnum == BestPayTypeEnum.ALIPAY_PC) {
            map.put("body",response.getBody());
            return new ModelAndView("createForAlipay",map);
        }

          throw new RuntimeException(("暂不支持的支付类型"));

    }

    /**
     * 微信异步通知 - 微信往业务程序发送一个Post请求
     * 接受参数不能用 RequestParam
     * */
    @PostMapping("/notify")
    @ResponseBody
    public String asyncNotify(@RequestBody String notifyData) {
        log.info("notifyData={}",notifyData);
        return payService.asyncNotify(notifyData);
    }
}
