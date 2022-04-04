package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Mouse;

/**
 * 戴尔鼠标
 */
public class DellMouse implements Mouse {


    @Override
    public String getName() {
        return "戴尔鼠标";
    }

    @Override
    public Integer getPrice() {
        return 50;
    }
}
