package com.demo.springdemo.advice;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // 在目标类方法调用前执行
        String clientName = (String)args[0];
        System.out.println("How are you! Mr."+clientName+".");
    }
}
