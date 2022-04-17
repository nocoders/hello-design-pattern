package com.hello.designPattern.PrototypePattern.model;

public class ConcretePrototype4 implements Cloneable{

    @Override
    public ConcretePrototype4 clone() {
        try {
            return (ConcretePrototype4) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
