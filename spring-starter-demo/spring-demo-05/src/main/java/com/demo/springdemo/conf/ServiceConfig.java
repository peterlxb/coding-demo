package com.demo.springdemo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {

    // 1.像普通Bean一样注入 DaoConfig
//    @Autowired
//    private DaoConfig daoConfig;

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();

        // 2.像普通Bean一样，调用 Bean相关方法
//        logonService.setLogDao(daoConfig.logDao());
//        logonService.setUserDao(daoConfig.userDao());

        return logonService;
    }
}
