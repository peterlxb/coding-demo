package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface CategoryMapper {

    @Select("select * from mall_category where id = #{id}")
    @Results({
            @Result(id = true,column = "id", property = "id")
    })
    Category findById(@Param("id") Integer id);

    Category queryById(Integer id);

}