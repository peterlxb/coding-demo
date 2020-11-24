package com.demo.springdemo.injectfun;

import org.springframework.beans.factory.support.MethodReplacer;
import java.lang.reflect.Method;

public class Boss2 implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        Car car = new Car();
        car.setBrand("美洲豹");
        return car;
    }
}
