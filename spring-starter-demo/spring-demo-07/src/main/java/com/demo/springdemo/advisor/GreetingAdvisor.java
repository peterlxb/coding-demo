package com.demo.springdemo.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import java.lang.reflect.Method;

public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 切点方法匹配规则: 方法名为 greetTo
        return "greetTo".equals(method.getName());
    }

    public ClassFilter getClassFilter() {
        // 切点类匹配规则: 为 Waiter 的类或子类
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
