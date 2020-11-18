package com.demo.springdemo.context;

import com.demo.springdemo.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class AnnotationApplicationContextTest {

    @Test
    public void getBean() {

        // 通过一个带 @configuration 的POJO 装载Bean配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car",Car.class);
        assertNotNull(car);
    }

}