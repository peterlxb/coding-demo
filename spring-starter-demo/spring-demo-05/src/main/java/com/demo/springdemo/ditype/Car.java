package com.demo.springdemo.ditype;

public class Car {

    private int maxSpeed;
    public String brand;
    private String corp;
    private double price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    // 该构造函数第一、第二入参都是 String 类型
    public Car(String brand, String corp, double price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public Car(String brand, String corp, int maxSpeed) {
        this.brand = brand;
        this.corp = corp;
        this.maxSpeed = maxSpeed;
    }

}
