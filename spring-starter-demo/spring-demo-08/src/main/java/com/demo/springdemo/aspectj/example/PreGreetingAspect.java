package com.demo.springdemo.aspectj.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 1.通过该注解将 PreGreetingAspect 标识为一个切面
@Aspect
public class PreGreetingAspect {

    // 2.定义切点和增强类型
    @Before("execution(* greetTo(..))")
    public void beforeGreeting() { // 3. 增强的横切逻辑
        System.out.println("How are you!");
    }
}
