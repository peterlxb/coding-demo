package com.spring.data.mybatisdemo.mapper;

import com.spring.data.mybatisdemo.model.Coffee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CoffeeMapper {
    /**
     * 定义 Insert
     * */
    @Insert("insert into t_coffee (name, price, create_time, update_time)"
            + "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Coffee coffee);

    /**
     * 定义 select
     * */
    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime")
    })
    Coffee findById(@Param("id") Long id);
}