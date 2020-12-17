package com.demo.springdemo.aspectj.example;

import com.demo.springdemo.NaiveWaiter;
import com.demo.springdemo.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJProxyTest {

    public static String configPath = "com/demo/springdemo/aspectj/example/beans.xml";
    public static org.springframework.context.ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

    public static void main(String[] args) {
//        proxy();
        configTest();
    }

    public static void proxy(){
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();

        // 1.设置目标对象
        factory.setTarget(target);
        // 2.添加切面类
        factory.addAspect(PreGreetingAspect.class);
        // 3.生成织入切面的代理对象
        Waiter proxy = factory.getProxy();

        proxy.greetTo("John");
        proxy.serveTo("John");
    }

    // 通过配置使用 @Aspect
    public static void configTest(){
        Waiter naiveWaiter = (Waiter) ctx.getBean("waiter");

        naiveWaiter.greetTo("John");
        naiveWaiter.serveTo("John");
    }
}
