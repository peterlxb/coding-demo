package com.demo.springdemo.cache.mycache;

public class UserMain {

    public static void main(String[] args) {
        UserService userService = new UserService();

        // 开始查询系统
        userService.getUserById("001001");
        userService.getUserById("001001");

        // 重置缓存
        userService.reload();

        System.out.println("after reloading...");

        // 应该是数据库查询
        userService.getUserById("001001");

        // 第二次查询，应该从缓存直接读取
        userService.getUserById("001001");
    }
}
