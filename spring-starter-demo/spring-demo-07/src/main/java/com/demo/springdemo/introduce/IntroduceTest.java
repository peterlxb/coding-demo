package com.demo.springdemo.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroduceTest {

    public static String configPath = "com/demo/springdemo/introduce/beans.xml";
    public static ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

    public static void main(String[] args) throws Exception {
        throwAdviceTest();
    }

    public static void throwAdviceTest() {
      ForumService forumService = (ForumService) ctx.getBean("forumService");

      forumService.removeForum(10);
      forumService.removeTopic(1022);

      Monitorable monitorable = (Monitorable) forumService;
      monitorable.setMonitorActive(true);

      forumService.removeForum(10);
      forumService.removeTopic(1022);
    }

}

