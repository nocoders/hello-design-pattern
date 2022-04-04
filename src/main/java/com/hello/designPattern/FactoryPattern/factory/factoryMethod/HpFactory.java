package com.hello.designPattern.FactoryPattern.factory.factoryMethod;

import com.hello.designPattern.FactoryPattern.interfaces.Factory;
import com.hello.designPattern.FactoryPattern.interfaces.Keyboard;
import com.hello.designPattern.FactoryPattern.interfaces.Mouse;
import com.hello.designPattern.FactoryPattern.model.HpKeyboard;
import com.hello.designPattern.FactoryPattern.model.HpMouse;

public class HpFactory implements Factory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
