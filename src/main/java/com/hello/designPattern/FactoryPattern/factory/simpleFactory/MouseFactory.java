package com.hello.designPattern.FactoryPattern.factory.simpleFactory;

import com.hello.designPattern.FactoryPattern.interfaces.Mouse;
import com.hello.designPattern.FactoryPattern.model.DellMouse;
import com.hello.designPattern.FactoryPattern.model.HpMouse;
import com.hello.designPattern.FactoryPattern.model.LogiMouse;

/**
 * 鼠标工厂类
 */
public class MouseFactory {

    public static Mouse createMouse(Integer type) throws IllegalAccessException {
        assert type != null;
        switch (type) {
            case 0:
                return new HpMouse();
            case 1:
                return new DellMouse();
            case 2:
                return new LogiMouse();
            default:
                throw new IllegalAccessException("参数异常");
        }
    }
}
