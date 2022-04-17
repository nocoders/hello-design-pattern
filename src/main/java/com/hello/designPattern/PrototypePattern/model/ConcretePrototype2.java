package com.hello.designPattern.PrototypePattern.model;

import com.hello.designPattern.PrototypePattern.simplePattern.Prototype;

public class ConcretePrototype2 implements Prototype {

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
