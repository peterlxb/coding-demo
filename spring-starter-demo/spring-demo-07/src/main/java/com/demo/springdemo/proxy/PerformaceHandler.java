package com.demo.springdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformaceHandler implements InvocationHandler {

    private Object target;

    // target 为目标类
    public PerformaceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(
                target.getClass().getName()+"."+method.getName());
        // 通过反射方法调用业务类的目标方法
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}
