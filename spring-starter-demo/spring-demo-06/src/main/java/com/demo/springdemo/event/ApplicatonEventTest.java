package com.demo.springdemo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicatonEventTest {

	public static void main(String[] args) {
		String resourceFile = "com/demo/springdemo/event/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);	
		MailSender mailSender = ctx.getBean(MailSender.class);
		mailSender.sendMail("test mail.");
	    System.out.println("done.");
	}
}
