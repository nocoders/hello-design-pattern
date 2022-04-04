package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Mouse;

/**
 * 罗技鼠标
 */
public class LogiMouse implements Mouse {


    @Override
    public String getName() {
        return "罗技鼠标";
    }

    @Override
    public Integer getPrice() {
        return 100;
    }
}
