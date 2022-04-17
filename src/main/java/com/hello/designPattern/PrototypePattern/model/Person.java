package com.hello.designPattern.PrototypePattern.model;

import java.io.*;

public class Person implements Cloneable, Serializable {
    private String name;
    private Integer age;
    private Department department;

    @Override
    public Object clone() throws CloneNotSupportedException {

        // 浅克隆
//        return super.clone();
        // 深克隆
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
