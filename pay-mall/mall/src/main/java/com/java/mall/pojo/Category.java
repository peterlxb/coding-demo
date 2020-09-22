package com.java.mall.pojo;

import java.util.Date;

/**
 * po (persistent object)
 * pojo (plain ordinary java object)
 *
 * Created by peter liu
 * 2020-09-22
 * */
public class Category {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;
}
