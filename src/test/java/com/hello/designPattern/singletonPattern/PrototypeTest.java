package com.hello.designPattern.singletonPattern;

import com.hello.designPattern.PrototypePattern.registerPattern.*;
import org.junit.Test;

public class PrototypeTest {

    @Test
    public void simplePrototypeTest(){
        Prototype prototype = new ConcretePrototype();
        Prototype clone = prototype.clone();
        System.out.println(prototype);
        System.out.println(clone);
        ConcretePrototype4 prototype2 = new ConcretePrototype4();
        ConcretePrototype4 clone2 = prototype2.clone();
        System.out.println(prototype2);
        System.out.println(clone2);
    }

    @Test
    public void registerTest() throws Exception {
        PrototypeManager.setProtoType("1",new ConcretePrototype());
        PrototypeManager.setProtoType("2",new ConcretePrototype2());
        Prototype prototype = PrototypeManager.getPrototype("1").clone();
        Prototype prototype2 = PrototypeManager.getPrototype("2").clone();
        System.out.println(prototype);
        System.out.println(prototype2);
    }
}
