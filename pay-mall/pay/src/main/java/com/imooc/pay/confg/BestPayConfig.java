package com.imooc.pay.confg;

import com.lly835.bestpay.config.AliPayConfig;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BestPayConfig {

    /**
     * 加上Bean注解，项目启动时会执行下面代码,
     * */
    @Bean
    public BestPayService bestPayService() {
        WxPayConfig wxPayConfig = new WxPayConfig();
        // 暂时写死，应该放在统一的配置文件中
        wxPayConfig.setAppId("wxd898fcb01713c658");
        wxPayConfig.setMchId("1483469312");
        wxPayConfig.setMchKey("098F6BCD4621D373CADE4E832627B4F6");

        // 异步回掉地址 -> 可以用云主机IP/报备过的域名
        wxPayConfig.setNotifyUrl("http://netease-paymall.natapp1.cc/pay/notify");

        // alipay config
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId("2018062960540016");
        aliPayConfig.setPrivateKey("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDUcbUUBaTJA4ngFx1xED2WHrkS4YCi3BRDPu/qU+MXj7VNy/ip+VKSK9aGPd2dRswkt/4DOoOxnnesJDcve+2W9y2gPoOdSVjGlEwTE6MqeB5f3l+RO9Kcb2zL4JwCRxlE0HHLeRdWtnmbelh1rg8zTFwGnoi1pbQajAT/FGDFqIpdI6FrEYbyeR/VNxFXIGK16Z7gfnWRnS4TP93O5ckcuaAcE8tqW16G7u41bKsnsv2149mucBM2hFSEVD/KcGYYke3pD7VpQdk0+WhxITSsa5I8DfSFRKokN7iJoKjYWjI4gN3fxFWLbymeIumoOWdJflwYI5oL+GdVIHfQ0ETLAgMBAAECggEBALaqurdnjuQkfcXIOlGAVGQjMKFycmgWcfnMQQAsdyRINe2Zx8tnDL+QoBm3UjmsqVWdOvVNt/TevCmwzh6vIYBgMsQJXKO+cG33D16L0Q1wUTW/gE7hsFtAV70J+TrgJXMNA/ufuBigN/oe/bbaHknOi4ZJhGUkALOe16D4xajNjHcYdvkfw5Zkv9nAt+GjFphe1lt35KIx6ahFzMcnzzHYy4ezDFdQWPkT7CqrL8Nh9KPm6Sjbzw2JP3RH91OU1q44gPj7yyLTs1oxt4gEqOgVnczJWXoH+eKRmxRoIvodnB4kf1W9LTzAc4Qs7OneDccvhrOoTD3MGhqW0poXZFkCgYEA6dxBCLnU5oeoctoltnh42DXCzEv/M/gkv9HMY/FFnuM6e0qU5EcFjQtTPRRW1S45ctZaHHhpGppHF7RG+okdALj4x2OC1NG9DL4HboVW3CJ4TzmEeZRkR+LWRWw7FA8eXefDBTC4ojAwqkmbvYP3dm6FjSfNBGYs43Wm6qKTcB0CgYEA6I5rPmAv6rB1BBXF8riNhuoDntbHFHOC9kCwuVJooDBBnxXNCqA9mTdnwE8hjgCgbO5lQkeeIRYiZwFYdCLPW78j6Np5CaX0/ZxcVSUQBFYc3d0e3po+rqpX6BGOj7qGhzDXvAs+HScu7ERy0Kbq6b/EbuLlR3oCKIGncGIaxAcCgYBJyWrjm+6mxgrKIjZf+mb2oQ/Tce8VsKe3tjRtHEVBOqTLHd8Yn6gKtpYO4Yn8PVd2+lb4QK247RCdVA5JIlX6UmJ8VtOC3qJtkM+7eWrMjjuzk4xO6Bkz7Uh6IwoI7DRCoMuRqau30MiqEguHoknEHl8ZCIPRbYOgSRDfW2h1qQKBgF9ODnFPphN+IVZ9PdRNAeMqgDVWO9wLwr38oPAx76LGY/44RwF1zgi+hgxv4YZ6h0RdJq5U/1773TltebyOj4BAAw1oi3YCxzYwID7co4XDbK0X85CykcGvGbuHhm8st/krcR4lVV1JM5esLYmI/nixGGWBIwl53OyQxffunJ19AoGBAOX9cBWFIWh5EHVXYvW90HRBQoo1AYtsdrxTedqrij6cWQms6ACeQZPd5O0V6/Lhz3Lw5NRnUl9MbzwOC7BBSBvhWwNzBOzFnaoOvBABa5nFZsdF5jSI3LJHbnxmMvxnKjCgogSGf+hfgR042b/WKDDBEA965MQJ59tCVhALD81z");
        aliPayConfig.setAliPayPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtojdtkETo4OEsQLeyyPwtWK9ZqYJANq6jjXC74vk9n/r88yW577y7VdxcK9X/F/wvR7D8of7lndYdhg6xZro0eO2skPZTU+A549J7tfzahVbIBAS+x1WPFJwPtVrfBBvkwHL8PT+YnMcxKyBxOa6wo8fzJs1NgU1+qnDCpwUFyv59GUfdzBvTPL1fY3ZzvRHFHbapevVltbO/jNV0thb8dafmcJXl8lnjQy3XlH3eTH28tlVfqickacfRl/WSD8WN3dGgF7dTDKYfSR7YB7jsHe6VzoHM3UnD9/yQbi/Z3ZrL7yOxEjq4tfrKlZIW7ZCoUpOU4QdPIRhLeC6nWyGrQIDAQAB");
        aliPayConfig.setNotifyUrl("http://netease-paymall.natapp1.cc/pay/notify");
        aliPayConfig.setReturnUrl("http://127.0.0.1");

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        bestPayService.setAliPayConfig(aliPayConfig);
        return bestPayService;
    }
}
