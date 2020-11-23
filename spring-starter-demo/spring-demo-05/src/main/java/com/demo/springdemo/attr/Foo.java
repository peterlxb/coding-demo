package com.demo.springdemo.attr;

public class Foo {

    // 非法的变量名，但是 Java 语言本身不会报错，因为它将 iDCode 看成普通变量
    private String iDCode;

    // 该 Setter 方法对应 IDCode 属性而非 iDCode属性
    public void setIDCode(String iDcode) {
        this.iDCode = iDcode;
    }
}
