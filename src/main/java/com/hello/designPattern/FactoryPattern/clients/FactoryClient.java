package com.hello.designPattern.FactoryPattern.clients;

import com.hello.designPattern.FactoryPattern.interfaces.Car;
import com.hello.designPattern.FactoryPattern.factory.QinCarFactory;

public class FactoryClient {
    public static void main(String[] args) throws IllegalAccessException {
        Car low = QinCarFactory.getCar("low");
        Car middle = QinCarFactory.getCar("middle");
        Car high = QinCarFactory.getCar("high");
        low.print();
        middle.print();
        high.print();
    }
}
