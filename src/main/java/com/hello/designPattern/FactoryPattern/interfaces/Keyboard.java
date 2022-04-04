package com.hello.designPattern.FactoryPattern.interfaces;

/**
 * 键盘接口
 */
public interface Keyboard {
    String getName();

    Integer getPrice();

    default void print() {
        System.out.println("键盘名称：" + getName() + "，键盘价格：" + getPrice());
    }
}
