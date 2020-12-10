package com.demo.springdemo.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {

    public static String configPath = "com/demo/springdemo/advisor/beans.xml";
    public static ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

    public static void main(String[] args) throws Exception {
//        staticMethodMatcherTest();
        regexpMethodMatcherTest();
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

}

