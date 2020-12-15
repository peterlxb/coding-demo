package com.demo.springdemo.anno;

public class ForumService {

    @NeedTest(value = true) // 标注注解
    public void deleteForum(int forumId) {
        System.out.println("删除论坛模块:"+forumId);
    }

    @NeedTest(value = false) // 标注注解
    public void deleteTopic(int topicId) {
        System.out.println("删除论坛主题:"+topicId);
    }
}
