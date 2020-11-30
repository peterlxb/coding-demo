package com.demo.springdemo.dynamic;

public class UserService {
  private UserDao  userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
