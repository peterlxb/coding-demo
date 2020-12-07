package com.demo.springdemo.proxy;

public class ForumServiceImpl implements ForumService {

    @Override
    public void removeTopic(int topicId) {
        // 将原先的横切代码移除(抽取切面中)
//        PerformanceMonitor.begin(
//                "com.demo.springdemo.proxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除 Topic记录: "+ topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 2.结束对该方法的性能监视
//        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
//        PerformanceMonitor.begin(
//                "com.demo.springdemo.proxy.ForumServiceImpl.removeForum");
        System.out.println("模拟删除 Forum记录: "+ forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        PerformanceMonitor.end();
    }
}
