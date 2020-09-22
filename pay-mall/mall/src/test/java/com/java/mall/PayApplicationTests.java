package com.java.mall;

import com.java.mall.dao.CategoryMapper;
import com.java.mall.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    // add first test
    @Test
    public void contextLoads() {

        Category category = categoryMapper.findById(100001);
        System.out.println(category.toString());
    }

}
