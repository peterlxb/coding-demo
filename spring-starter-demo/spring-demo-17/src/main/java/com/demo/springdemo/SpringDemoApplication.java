package com.demo.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDemoApplication {

  public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}



