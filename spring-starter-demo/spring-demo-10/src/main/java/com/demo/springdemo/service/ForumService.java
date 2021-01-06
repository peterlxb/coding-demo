package com.demo.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForumService {

    @Autowired
    private UserService userService;

    @Transactional(propagation=Propagation.NEVER)
    public void addTopic(){
    	//add Topic
		userService.addCredits();
    }
}
