package com.demo.springdemo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// 1.通过 @ImportResource 引入 XML 配置文件
@Configuration
@ImportResource("classpath:com/demo/springdemo/conf/beans3.xml")
public class LogonAppConfig {

    // 2.自动注入XML文件中定义的Bean
    @Bean
    @Autowired
    public LogonService logonService(UserDao userDao,LogDao logDao) {
        LogonService logonService = new LogonService();

        logonService.setUserDao(userDao);
        logonService.setLogDao(logDao);
        return logonService;
    }
}
