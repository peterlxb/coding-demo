package com.demo.springdemo.lock.lockscope;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class Interesting {

    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add() {
        log.info("add start");
        for (int i = 0;i < 100000;i++) {
            a++;
            b++;
        }
        log.info("add done");
    }

    public synchronized void compare() {
        log.info("compare start");
        for (int i = 0; i < 100000; i++) {
            // a 始终等于 b 么?
            if (a < b) {
                log.info("a:{}, b:{}, {}", a,b, a>b);
            }
        }
        log.info("compare done");
    }

    public synchronized void compareRight() {
        log.info("compare start");
        for (int i = 0; i< 100000; i++) {
            Assert.assertTrue(a == b);

            if (a< b) {
                log.info("a:{}, b:{}, {}", a,b, a>b);
            }
            log.info("compare done");
        }
    }
}
