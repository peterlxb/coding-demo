package com.demo.springdemo;

import com.demo.springdemo.dao.ForumDao;
import com.demo.springdemo.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

    @Autowired
    private ForumDao forumDao;


    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Forum forum  = new Forum();
        forum.setForumId(123);
        forum.setForumDesc("First Forum");
        forum.setForumName("ForumDemo");

        forumDao.addForum(forum);
    }
}

