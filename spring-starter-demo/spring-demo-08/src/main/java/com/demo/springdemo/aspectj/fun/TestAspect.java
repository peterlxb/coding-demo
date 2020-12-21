package com.demo.springdemo.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {

    // 后置增强切面
    @AfterReturning("@annotation(com.demo.springdemo.anno.NeedTest)")
    public void needTestFun() {
        System.out.println("needTestFun() executed!");
    }
}
