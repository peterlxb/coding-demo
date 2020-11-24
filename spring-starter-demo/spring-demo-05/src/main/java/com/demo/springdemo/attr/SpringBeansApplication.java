package com.demo.springdemo.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansApplication {

    public static void main(String[] args) {
        // 父容器
        ClassPathXmlApplicationContext parentFactory = new ClassPathXmlApplicationContext(new String[]{"com/demo/springdemo/attr/beans1.xml"});

        // 指定 parentFactory 为该容器的父容器
        ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{"com/demo/springdemo/attr/beans2.xml"},parentFactory);

        Boss boss = (Boss)factory.getBean("boss");
        System.out.println(boss.toString());
        System.out.println(boss.getMails().toString());
        System.out.println(boss.getCar().toString());
    }
}

