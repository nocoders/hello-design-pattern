package com.hello.designPattern.FactoryPattern.factory;

import com.hello.designPattern.FactoryPattern.interfaces.Car;
import com.hello.designPattern.FactoryPattern.model.BYDHanCar;
import com.hello.designPattern.FactoryPattern.model.BYDTangCar;
import com.hello.designPattern.FactoryPattern.model.BYDQinCar;

public class BYDCarFactory {

    public static Car getCar(String carType) {
        switch (carType) {
            case "han":
                return new BYDHanCar();
            case "tang":
                return new BYDTangCar();
            case "qin":
                return new BYDQinCar();
            default:
                throw new IllegalArgumentException("param error");
        }
    }
}
