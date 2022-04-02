package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Car;

public class BYDHanCar implements Car{

    @Override
    public Integer getPrice() {
        return 50000;
    }

    @Override
    public String getName() {
        return "比亚迪汉";
    }

}
