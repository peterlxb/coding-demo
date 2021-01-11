package com.demo.springdemo.cache.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String userId;

    private String userName;

    private int age;

    public User() {

    }

    public User(String userId) {
        this.userId = userId;
    }
}
