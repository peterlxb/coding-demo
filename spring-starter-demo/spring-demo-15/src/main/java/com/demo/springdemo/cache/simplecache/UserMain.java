package com.demo.springdemo.cache.simplecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");// 加载 spring 配置文件

        UserService userService = (UserService) context.getBean("userServiceBean");

        // 开始查询系统
        System.out.println("first query...");
        userService.getUserById("somebody");

        // 第二次查询
        System.out.println("second query...");
        userService.getUserById("somebody");
    }
}
