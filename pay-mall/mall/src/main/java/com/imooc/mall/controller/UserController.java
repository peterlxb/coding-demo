package com.imooc.mall.controller;

import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.UserForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


/**
 * Created By Peter Liu
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * form-url-encode 方式

     @PostMapping("/register")
     public void register(@RequestParam String username) {
        log.info("username={}", username);
     }
     */

    @PostMapping("/register")
    public ResponseVo register(@Valid @RequestBody UserForm userForm, BindingResult bindingResult) {

        // 校验基本字段
        if (bindingResult.hasErrors()) {
            log.error("注册提交的参数有误, {} {}",
                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());

            return ResponseVo.error(ResponseEnum.PARAM_ERROR, bindingResult);
        }

        log.info("username={}", userForm.getUsername());
//        return ResponseVo.success("注册成功");
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
