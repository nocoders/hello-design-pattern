package com.hello.designPattern.FactoryPattern.interfaces;

/**
 * 鼠标接口
 */
public interface Mouse {
    String getName();

    Integer getPrice();

    default void print() {
        System.out.println("鼠标名称：" + getName() + "，鼠标价格：" + getPrice());
    }
}
