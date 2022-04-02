package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Car;

public class BYDTangCar implements Car{

    @Override
    public Integer getPrice() {
        return 60000;
    }

    @Override
    public String getName() {
        return "比亚迪唐";
    }

}
