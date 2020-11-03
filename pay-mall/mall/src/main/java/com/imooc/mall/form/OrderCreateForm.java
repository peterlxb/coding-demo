package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created By Peter Liu
 */
@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;
}
