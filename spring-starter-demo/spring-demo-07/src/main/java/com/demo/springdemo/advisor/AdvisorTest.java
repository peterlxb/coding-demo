package com.demo.springdemo.advisor;

import com.demo.springdemo.introduce.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {

    public static String configPath = "com/demo/springdemo/advisor/beans.xml";
    public static ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

    public static void main(String[] args) throws Exception {
//        staticMethodMatcherTest();
//        regexpMethodMatcherTest();
//        dynamicMethodMatcherTest();
//        defaultAdvisorTest();
//        composableAdvisorTest();
        controlFlowTest();
    }


    public static void staticMethodMatcherTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");

        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }

    public static void regexpMethodMatcherTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter1");

        waiter.greetTo("John");
        waiter.serveTo("John");
    }

    // 动态切面测试
    public static void dynamicMethodMatcherTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter2");

        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }

    // 流程切面测试
    public static void controlFlowTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter3");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        wd.service("Peter");
    }

    // 复合切面测试
    public static void composableAdvisorTest() {
        Waiter waiter = (Waiter) ctx.getBean("waiter4");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        wd.service("Peter");
    }

    // 引介切面测试
    public static void defaultAdvisorTest() {
        ForumService forumService = (ForumService) ctx.getBean("forumService");

        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }
}

