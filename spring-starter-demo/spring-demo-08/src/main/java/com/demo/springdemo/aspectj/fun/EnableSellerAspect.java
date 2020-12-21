package com.demo.springdemo.aspectj.fun;

import com.demo.springdemo.Seller;
import com.demo.springdemo.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

    @DeclareParents(value = "com.demo.springdemo.NaiveWaiter",
            defaultImpl = SmartSeller.class)
    public static Seller seller;

}
