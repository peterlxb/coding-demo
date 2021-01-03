package com.imooc.mall.service;

import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;

public interface IUserService {

    /**
     * 注册
     */
    ResponseVo<User> register(User user);

    /**
     * 登陆
     */
    ResponseVo<User> login(String username, String password);
}
