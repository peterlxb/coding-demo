package com.demo.springdemo.web;

import com.demo.springdemo.domain.User;
import com.demo.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.concurrent.Callable;

@RestController
public class UserRestController {

  @Autowired
  private UserService userService;

  @RequestMapping("/api")
  public Callable<User> api() {
    System.out.println("=======hello");
    return new Callable<User>() {
      @Override
      public User call() throws Exception {
        Thread.sleep(10L * 1000);
        User user = new User();
        user.setUserId("1222");
        user.setUserName("haha");
        return user;
      }
    };
  }

}
