package com.demo.springdemo.aspectj.basic;

import com.demo.springdemo.Seller;
import com.demo.springdemo.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

    @DeclareParents(value = "com.demo.springdemo.NaiveWaiter", // 为 NaiveWaiter 添加接口实现
    defaultImpl = SmartSeller.class) // 默认的接口实现类
    public Seller seller; // 要实现的目标接口
}
