package com.imooc.mall.enums;

import lombok.Getter;

/***
 * Created By Peter Liu
 */
@Getter
public enum PaymentTypeEnum {

    PAY_ONLINE(1),
    ;

    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code =code;
    }
}
