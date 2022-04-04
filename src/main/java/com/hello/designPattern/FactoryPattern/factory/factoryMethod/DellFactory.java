package com.hello.designPattern.FactoryPattern.factory.factoryMethod;

import com.hello.designPattern.FactoryPattern.interfaces.Factory;
import com.hello.designPattern.FactoryPattern.interfaces.Keyboard;
import com.hello.designPattern.FactoryPattern.interfaces.Mouse;
import com.hello.designPattern.FactoryPattern.model.DellKeyboard;
import com.hello.designPattern.FactoryPattern.model.DellMouse;

public class DellFactory implements Factory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
