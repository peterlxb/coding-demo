package com.demo.springdemo.proxy;

import java.lang.reflect.Proxy;

public class TestForumService {

    public static void main(String[] args) {
//        test();
//        proxy();
        CglibProxy();
    }


    private static void proxy() {
        // 1. 希望被代理的目标类
        ForumService target = new ForumServiceImpl();

        // 2. 将目标业务类和横切代码编织在一起
        PerformaceHandler handler = new PerformaceHandler(target);

        // 3. 根据编织了目标业务类逻辑和性能监视横切逻辑
        // 的 InvocationHandler 实例创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );

        proxy.removeTopic(1012);
        proxy.removeForum(10);
    }

    private static void CglibProxy() {
        CglibProxy proxy = new CglibProxy();
        // 通过动态生成子类的方式创建代理类
        ForumServiceImpl forumService =
                (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }

    private static void test() {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}

