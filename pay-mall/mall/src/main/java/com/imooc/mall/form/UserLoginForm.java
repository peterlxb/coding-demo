package com.imooc.mall.form;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * Created By Peter Liu
 *
 * Controller 接收到的参数用form包装
 */
@Data
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}


