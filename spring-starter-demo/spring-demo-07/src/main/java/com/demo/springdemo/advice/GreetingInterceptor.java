package com.demo.springdemo.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 目标方法入参
        Object[] args = invocation.getArguments();
        String clientName = (String) args[0];

        // 在目标方法执行前触发
        System.out.println("How are you!Mr." + clientName +".");

        // 通过反射机制调用目标方法
        Object obj = invocation.proceed();

        // 在目标方法执行后触发
        System.out.println("Please enjoy yourself!");

        return obj;
    }
}
