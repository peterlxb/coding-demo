package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * Created By peter Liu
 *
 * Category 接口返回的值
 * */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
