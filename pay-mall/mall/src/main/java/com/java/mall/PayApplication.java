package com.java.mall;

import com.java.mall.dao.CategoryMapper;
import com.java.mall.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan(basePackages = "com.java.mall.dao")
public class PayApplication implements ApplicationRunner {

    @Autowired
    private CategoryMapper categoryMapper;

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        Category category = categoryMapper.findById(100005);
        log.info("Find category: {}", category);

        Category category1 = categoryMapper.queryById(100004);
        log.info("Find xml category: {}", category1);
    }

}
