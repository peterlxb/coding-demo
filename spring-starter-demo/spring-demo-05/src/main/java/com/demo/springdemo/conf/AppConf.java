package com.demo.springdemo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 1.将一个 POJO 标注为定义Bean的配置类
@Configuration
public class AppConf {

    // 2. 以下两个方法定义两个Bean，并提供了Bean 的实例化逻辑
    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public LogDao logDao() {
        return new LogDao();
    }

    // 3.定义了logonService 的Bean
    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();

        // 4.将2处定义的Bean 注入到logonService 的Bean中
        logonService.setUserDao(userDao());
        logonService.setLogDao(logDao());

        return logonService;
    }

}
