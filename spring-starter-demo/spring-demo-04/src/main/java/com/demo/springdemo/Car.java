package com.demo.springdemo;

public class Car {

    private String brand;
    private String color;
    private int maxSpeed;

    // empty constructor
    public Car() {}

    // constructor with parameter
    public Car(String brand,String color, Integer maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed= maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性。");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "brand:" + brand + "/color:" + color + "/maxSpeed:"+ maxSpeed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void introduce(){
        System.out.println("introduce:"+this.toString());
    }


}
