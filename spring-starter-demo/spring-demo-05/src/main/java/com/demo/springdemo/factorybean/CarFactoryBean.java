package com.demo.springdemo.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;
    public String getCarInfo() {
        return carInfo;
    }

    // 接收逗号分隔的属性设置信息
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    // 实例化 car Bean
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        return car;
    }

    // 返回 Car 的类型
    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    // 标识通过该 FactoryBean 返回的 Bean 是 singleton
    @Override
    public boolean isSingleton() {
        return false;
    }
}
