package com.hello.designPattern.PrototypePattern.registerPattern;

public class ConcretePrototype implements Prototype{

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
