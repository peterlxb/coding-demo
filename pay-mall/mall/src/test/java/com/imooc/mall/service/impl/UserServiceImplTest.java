package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    @Autowired
    IUserService userService;

    @Test
    public void register() {
        User user = new User("Jack","123456","jack@163.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}