package com.hello.designPattern.FactoryPattern.factory;

import com.hello.designPattern.FactoryPattern.interfaces.Car;
import com.hello.designPattern.FactoryPattern.model.HanCar;
import com.hello.designPattern.FactoryPattern.model.QinCar;
import com.hello.designPattern.FactoryPattern.model.TangCar;

public class QinCarFactory {

    public static Car getCar(String carType) throws IllegalAccessException {
        return switch (carType) {
            case "low" -> new HanCar();
            case "middle" -> new TangCar();
            case "high" -> new QinCar();
            default -> throw new IllegalAccessException("param error");
        };
    }
}
