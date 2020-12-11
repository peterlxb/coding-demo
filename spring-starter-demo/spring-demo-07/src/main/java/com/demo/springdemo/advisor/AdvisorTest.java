package com.demo.springdemo.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {

    public static String configPath = "com/demo/springdemo/advisor/beans.xml";
    public static ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

    public static void main(String[] args) throws Exception {
//        staticMethodMatcherTest();
//        regexpMethodMatcherTest();
        dynamicMethodMatcherTest();
    }

    public static void staticMethodMatcherTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");

        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }

    public static void regexpMethodMatcherTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter1");

        waiter.greetTo("John");
        waiter.serveTo("John");
    }

    // 动态切面测试
    public static void dynamicMethodMatcherTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter2");

        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }

}

