package com.demo.springdemo.lock.lockscope;

import com.demo.springdemo.SpringDemoApplicationTests;
import org.junit.Test;

public class InterestingTest extends SpringDemoApplicationTests {

    @Test
    public void testLock() {
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }
}