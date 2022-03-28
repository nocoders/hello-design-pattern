package com.hello.designPattern.FactoryPattern.clients;

import com.hello.designPattern.FactoryPattern.interfaces.Car;
import com.hello.designPattern.FactoryPattern.factory.QinCarFactory;

public class FactoryClient {
    public static void main(String[] args) throws IllegalAccessException {
        Car han = QinCarFactory.getCar("han");
        Car tang = QinCarFactory.getCar("tang");
        Car qin = QinCarFactory.getCar("qin");
        han.print();
        tang.print();
        qin.print();
    }
}
