package com.demo.springdemo.aspectj.basic;

import com.demo.springdemo.Seller;
import com.demo.springdemo.SpringDemoApplicationTests;
import com.demo.springdemo.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclaredParentsTest extends SpringDemoApplicationTests {

    public static void main(String[] args) {
        String configPath = "com/demo/springdemo/aspectj/basic/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter= (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        Seller seller = (Seller) waiter;
        seller.sell("Beer", "John");
    }
}