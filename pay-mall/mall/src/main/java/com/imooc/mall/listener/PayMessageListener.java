package com.imooc.mall.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created By Peter Liu
 * */
@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMessageListener {

    @RabbitHandler
    public void process(String msg) {
        log.info("【接收到消息】=> {}",msg);
    }
}
