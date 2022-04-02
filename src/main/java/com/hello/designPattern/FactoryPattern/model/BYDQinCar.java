package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Car;

public class BYDQinCar implements Car{

    @Override
    public Integer getPrice() {
        return 65000;
    }

    @Override
    public String getName() {
        return "比亚迪秦";
    }
}
