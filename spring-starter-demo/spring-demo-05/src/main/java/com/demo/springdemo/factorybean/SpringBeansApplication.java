package com.demo.springdemo.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeansApplication {

    public static void main(String[] args) {

        String[] CONFIG_FILES = { "com/demo/springdemo/factorybean/beans.xml" };
        ApplicationContext factory = new ClassPathXmlApplicationContext(CONFIG_FILES);

        Car car = (Car) factory.getBean("car");
        System.out.println(car.toString());
    }
}

