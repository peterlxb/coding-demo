package com.demo.springdemo.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigTestApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(DaoConfig.class);
        ctx.register(ServiceConfig.class);

        ctx.refresh();

        // 使用@Configuration 类提供的 Bean 定义信息启动容器
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
//
        LogonService logonService = ctx.getBean(LogonService.class);
        logonService.printHelllo();
    }
}

