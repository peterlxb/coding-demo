package com.demo.springdemo.domain;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class User {

    private String userId;

    // 通过正则表达式校验，匹配4-30个包含数字、字母及下划线的字符
    @Pattern(regexp = "w(4,30)")
    private String userName;

    // 匹配 6-30个非空白的字符
    @Pattern(regexp = "S(6,30)")
    private String password;

    // Hibernate Validator 的扩展注解，将属性值的长度控制在2-100之间
    @Length(min=2,max = 100)
    private String realName;

    // 时间值必须是过去的时间
    @Past
    private Date birthday;

    // 数据必须在 1000.00 - 100000.00 之间
    @DecimalMin(value = "1000.00")
    @DecimalMax(value = "100000.00")
    private long salary;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public User() {}

    public User(String userName,String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
