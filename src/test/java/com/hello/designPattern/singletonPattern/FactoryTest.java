package com.hello.designPattern.singletonPattern;

import com.hello.designPattern.FactoryPattern.factory.factoryMethod.DellFactory;
import com.hello.designPattern.FactoryPattern.factory.factoryMethod.HpFactory;
import com.hello.designPattern.FactoryPattern.factory.factoryMethod.LogiFactory;
import com.hello.designPattern.FactoryPattern.factory.simpleFactory.MouseFactory;
import com.hello.designPattern.FactoryPattern.interfaces.Mouse;
import org.junit.Test;

public class FactoryTest {
    @Test
    public void simpleFactoryTest() throws IllegalAccessException {
        Mouse mouse = MouseFactory.createMouse(0);
        mouse.print();
        Mouse mouse1 = MouseFactory.createMouse(1);
        mouse1.print();
        Mouse mouse2 = MouseFactory.createMouse(2);
        mouse2.print();
    }

    @Test
    public void factoryMethodTest(){
        Mouse hoMouse = new HpFactory().createMouse();
        Mouse dellMouse = new DellFactory().createMouse();
        Mouse logiMouse = new LogiFactory().createMouse();
        hoMouse.print();
        dellMouse.print();
        logiMouse.print();
    }
    @Test
    public void abstractFactoryTest(){
        HpFactory hpFactory = new HpFactory();
        LogiFactory logiFactory = new LogiFactory();
        DellFactory dellFactory = new DellFactory();

        Mouse hoMouse = hpFactory.createMouse();
        Mouse dellMouse = dellFactory.createMouse();
        Mouse logiMouse = logiFactory.createMouse();
        hoMouse.print();
        dellMouse.print();
        logiMouse.print();

        hpFactory.createKeyboard().print();
        logiFactory.createKeyboard().print();
        dellFactory.createKeyboard().print();
    }
}
