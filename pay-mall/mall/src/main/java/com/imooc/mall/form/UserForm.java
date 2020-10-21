package com.imooc.mall.form;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * Created By Peter Liu
 *
 * Controller 接收到的参数用form包装
 */
@Data
public class UserForm {

    // @NotBlank(message = "用户名不能为空") 用于 String 判断空格
    // @NotEmpty 用于集合
    // @NotNull
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
