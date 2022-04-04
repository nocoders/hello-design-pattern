package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Keyboard;

/**
 * 戴尔键盘
 */
public class DellKeyboard implements Keyboard {


    @Override
    public String getName() {
        return "戴尔键盘";
    }

    @Override
    public Integer getPrice() {
        return 50;
    }
}
