package com.hello.designPattern.FactoryPattern.factory.factoryMethod;

import com.hello.designPattern.FactoryPattern.interfaces.Factory;
import com.hello.designPattern.FactoryPattern.interfaces.Keyboard;
import com.hello.designPattern.FactoryPattern.interfaces.Mouse;
import com.hello.designPattern.FactoryPattern.model.LogiKeyboard;
import com.hello.designPattern.FactoryPattern.model.LogiMouse;

public class LogiFactory implements Factory {
    @Override
    public Mouse createMouse() {
        return new LogiMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new LogiKeyboard();
    }
}
