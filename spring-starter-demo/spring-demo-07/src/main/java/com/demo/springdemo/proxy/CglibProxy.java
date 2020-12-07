package com.demo.springdemo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 1. 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 2. 通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            // 3. 拦截父类所有方法的调用
                            MethodProxy methodProxy)
            throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "."+method.getName());
        // 4. 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(obj, args);
        PerformanceMonitor.end();
        return result;
    }
}
