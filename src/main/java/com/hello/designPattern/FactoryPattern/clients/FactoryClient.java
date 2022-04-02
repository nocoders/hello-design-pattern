package com.hello.designPattern.FactoryPattern.clients;

import com.hello.designPattern.FactoryPattern.interfaces.Car;
import com.hello.designPattern.FactoryPattern.factory.BYDCarFactory;

public class FactoryClient {
    public static void main(String[] args) throws IllegalAccessException {
        Car low = BYDCarFactory.getCar("qin");
        Car middle = BYDCarFactory.getCar("han");
        Car high = BYDCarFactory.getCar("tang");
        low.print();
        middle.print();
        high.print();
    }
}
