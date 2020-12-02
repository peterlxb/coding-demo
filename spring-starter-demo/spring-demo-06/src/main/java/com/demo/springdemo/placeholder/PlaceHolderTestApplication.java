package com.demo.springdemo.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.activation.DataSource;

public class PlaceHolderTestApplication {

    public static void main(String[] args) {
        String resourceFile = "com/demo/springdemo/placeholder/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);

        MyDataSource dataSource = (MyDataSource)ctx.getBean(MyDataSource.class);
        System.out.println(dataSource.toString());
    }
}

