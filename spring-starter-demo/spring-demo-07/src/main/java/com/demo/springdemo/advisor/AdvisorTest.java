package com.demo.springdemo.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {

    public static String configPath = "com/demo/springdemo/advisor/beans.xml";
    public static ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

    public static void main(String[] args) throws Exception {
        staticMethodMatcherTest();
    }

    public static void staticMethodMatcherTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");

        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }

}

