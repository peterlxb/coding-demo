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

    /**
     {
        "status": 0,
        "data": [{
        "id": 100001,
             "parentId": 0,
             "name": "家用电器",
             "sortOrder": 1,
             "subCategories": [{
             "id": 100006,
             "parentId": 100001,
             "name": "冰箱",
             "sortOrder": 2,
             "subCategories": [{
             "id": 100040,
             "parentId": 100006,
             "name": "进口冰箱",
             "sortOrder": 1,
             "subCategories": []
             }]
            },
        {
        "id": 100005,
         "parentId": 0,
         "name": "酒水饮料",
         "sortOrder": 1,
         "subCategories": [{
         "id": 100026,
         "parentId": 100005,
         "name": "白酒",
         "sortOrder": 1,
         "subCategories": []
        }, {
         "id": 100027,
         "parentId": 100005,
         "name": "红酒",
         "sortOrder": 1,
         "subCategories": []
         }]
      }]
     }
     * */

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
