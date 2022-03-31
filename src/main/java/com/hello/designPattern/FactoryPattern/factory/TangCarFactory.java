package com.hello.designPattern.FactoryPattern.factory;

import com.hello.designPattern.FactoryPattern.interfaces.Car;
import com.hello.designPattern.FactoryPattern.model.HighCar;
import com.hello.designPattern.FactoryPattern.model.LowCar;
import com.hello.designPattern.FactoryPattern.model.MiddleCar;

public class TangCarFactory {

    public static Car getCar(String carType) throws IllegalAccessException {
        switch (carType) {
            case "low":
                return new LowCar();
            case "middle":
                return new MiddleCar();
            case "high":
                return new HighCar();
            default:
                throw new IllegalAccessException("param error");
        }
    }
}
