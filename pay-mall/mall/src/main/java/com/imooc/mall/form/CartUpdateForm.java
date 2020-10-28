package com.imooc.mall.form;

import lombok.Data;

@Data
public class CartUpdateForm {

    private Integer quantity;

    protected Boolean selected;
}
