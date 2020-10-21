package com.imooc.mall.controller;

import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * Created By Peter Liu
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * form-urlencode 方式

     @PostMapping("/register")
     public void register(@RequestParam String username) {
        log.info("username={}", username);
     }
     */

    @PostMapping("/register")
    public ResponseVo register(@RequestBody User user) {
        log.info("username={}", user.getUsername());

//        return ResponseVo.success("注册成功");
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
