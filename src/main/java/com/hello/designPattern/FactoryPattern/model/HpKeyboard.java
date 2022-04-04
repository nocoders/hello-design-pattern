package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Keyboard;

/**
 * 惠普键盘
 */
public class HpKeyboard implements Keyboard {


    @Override
    public String getName() {
        return "惠普键盘";
    }

    @Override
    public Integer getPrice() {
        return 333;
    }
}
