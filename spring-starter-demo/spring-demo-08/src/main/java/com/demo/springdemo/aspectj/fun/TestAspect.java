package com.demo.springdemo.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {

    // 后置增强切面
//    @AfterReturning("@annotation(com.demo.springdemo.anno.NeedTest)")
//    public void needTestFun() {
//        System.out.println("needTestFun() executed!");
//    }

    // 后置增强切面，织入任何运行期对象为Seller类型的Bean中
    @AfterReturning("target(com.demo.springdemo.Seller)")
    public void thisTest() {
        System.out.println("thisTest() executed!");
    }
}
