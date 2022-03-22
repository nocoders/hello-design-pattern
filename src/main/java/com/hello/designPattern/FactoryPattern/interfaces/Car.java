package com.hello.designPattern.FactoryPattern.interfaces;

public interface Car {
    Integer getPrice();
    String getName();
    default void print(){
        System.out.println("车辆型号："+getName()+",车辆价格："+getPrice());
    }
}
