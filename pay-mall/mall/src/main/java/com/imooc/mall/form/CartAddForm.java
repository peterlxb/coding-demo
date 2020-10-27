package com.imooc.mall.form;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 添加商品
 * Created By Peter Liu
 * */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    // 默认选中
    private boolean selected = true;
}
