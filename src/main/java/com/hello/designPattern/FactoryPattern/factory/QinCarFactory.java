package com.hello.designPattern.FactoryPattern.factory;

import com.hello.designPattern.FactoryPattern.interfaces.Car;
import com.hello.designPattern.FactoryPattern.model.HanCar;
import com.hello.designPattern.FactoryPattern.model.QinCar;
import com.hello.designPattern.FactoryPattern.model.TangCar;

public class QinCarFactory {

    public static Car getCar(String carType) throws IllegalAccessException {
        switch (carType) {
            case "han":
                return new HanCar();
            case "tang":
                return new TangCar();
            case "qin":
                return new QinCar();
            default:
                throw new IllegalAccessException("param error");
        }
    }
}
