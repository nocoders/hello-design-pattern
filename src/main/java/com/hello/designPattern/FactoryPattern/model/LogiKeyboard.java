package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Keyboard;

/**
 * 罗技键盘
 */
public class LogiKeyboard implements Keyboard {


    @Override
    public String getName() {
        return "罗技键盘";
    }

    @Override
    public Integer getPrice() {
        return 999;
    }
}
