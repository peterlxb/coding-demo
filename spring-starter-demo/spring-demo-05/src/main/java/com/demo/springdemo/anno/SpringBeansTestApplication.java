package com.demo.springdemo.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansTestApplication {

    public static void main(String[] args) {
        String[] CONFIG_FILES = { "com/demo/springdemo/anno/beans.xml" };

        // 启动容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(CONFIG_FILES);

        // 关闭容器
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}

