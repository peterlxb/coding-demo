package com.spring.web.context;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class TestBean {

    private String context;

    // 要增强的目标
    public void hello() {
        log.info("TestBean hello " + context);
    }
}
