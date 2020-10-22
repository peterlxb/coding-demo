package com.imooc.mall.exception;

import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created By Peter Liu
 * 统一异常处理
 * */
@ControllerAdvice
public class RuntimeExceptionHandler {

    // 返回json格式/要捕获的类
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVo handle(RuntimeException e) {
        // 返回通用的错误
        return ResponseVo.error(ResponseEnum.ERROR, e.getMessage());
    }

    // 捕获User拦截器异常
    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseVo userLoginHandler() {
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
