package com.demo.springdemo.aspectj.fun;

import com.demo.springdemo.SpringDemoApplicationTests;
import com.demo.springdemo.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutFunTest extends SpringDemoApplicationTests {

    @Test
    public void pointCut() {
        String configPath = "com/demo/springdemo/aspectj/fun/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter= (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");

        naiveWaiter.greetTo("John");
        naughtyWaiter.greetTo("Tom");
    }
}