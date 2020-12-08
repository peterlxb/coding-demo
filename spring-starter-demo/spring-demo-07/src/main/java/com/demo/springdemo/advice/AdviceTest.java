package com.demo.springdemo.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {

    public static void main(String[] args) {
//        before();
        beforeWithSpring();
    }


    // 前置增强
    private static void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // 1.Spring 提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        // 指定对接口进行代理(将使用 JDK 动态代理技术)
        pf.setInterfaces(target.getClass().getInterfaces());
        // 启用优化(启用优化后，还将使用 Cglib2AopProxy 代理)
        pf.setOptimize(true);

        // 2.设置代理目标
        pf.setTarget(target);

        // 3.为代理目标添加增强
        pf.addAdvice(advice);

        // 4.生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

    // 测试基于 Spring 的代理
    private static void beforeWithSpring() {
        String configPath = "com/demo/springdemo/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John Dow");
    }

}

