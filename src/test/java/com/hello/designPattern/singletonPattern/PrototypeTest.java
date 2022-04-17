package com.hello.designPattern.singletonPattern;

import com.hello.designPattern.PrototypePattern.model.*;
import com.hello.designPattern.PrototypePattern.registerPattern.*;
import com.hello.designPattern.PrototypePattern.simplePattern.Prototype;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.SerializationUtils;

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

    @Test
    public void shallowCloning() throws CloneNotSupportedException {
        Department department = new Department();
        department.setName("互联网部门");
        department.setDesc("互联网部门说明");
        Person person = new Person();
        person.setName("小明");
        person.setAge(22);
        person.setDepartment(department);

//        Person person1 = (Person) person.clone();
        Person person1 = new Person();
        BeanUtils.copyProperties(person,person1);

        System.out.println(person);
        System.out.println(person1);
    }
    @Test
    public void deepCloning() throws CloneNotSupportedException {
        Department department = new Department();
        department.setName("互联网部门");
        department.setDesc("互联网部门说明");
        Person person = new Person();
        person.setName("小明");
        person.setAge(22);
        person.setDepartment(department);
        System.out.println(person);
        Person personClone = (Person) person.clone();
        System.out.println(personClone);
        byte[] serialize = SerializationUtils.serialize(person);
        Person deserialize = (Person) SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);
    }
}
