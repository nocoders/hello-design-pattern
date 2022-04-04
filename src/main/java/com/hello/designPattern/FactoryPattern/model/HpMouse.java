package com.hello.designPattern.FactoryPattern.model;

import com.hello.designPattern.FactoryPattern.interfaces.Mouse;

/**
 * 惠普鼠标
 */
public class HpMouse implements Mouse {


    @Override
    public String getName() {
        return "惠普鼠标";
    }

    @Override
    public Integer getPrice() {
        return 10;
    }
}
