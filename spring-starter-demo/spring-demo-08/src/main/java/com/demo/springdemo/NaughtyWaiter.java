package com.demo.springdemo;

import com.demo.springdemo.anno.NeedTest;

public class NaughtyWaiter implements Waiter {

    @NeedTest
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter:greet to "+clientName+"...");
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaughtyWaiter:serving "+clientName+"...");
    }
}
