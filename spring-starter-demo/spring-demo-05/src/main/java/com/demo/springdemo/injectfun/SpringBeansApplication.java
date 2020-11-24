package com.demo.springdemo.injectfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansApplication {

    public static void main(String[] args) {

        String[] CONFIG_FILES = { "com/demo/springdemo/injectfun/beans.xml" };
        ApplicationContext factory = new ClassPathXmlApplicationContext(CONFIG_FILES);

        MagicBoss mboss = (MagicBoss) factory.getBean("magicBoss");
        System.out.println(mboss.getCar());
    }
}

