package com.joker.reflect.practice;

import java.io.Serializable;

/**
 * @Author: wzp
 * @Date: 2020/8/29 7:54
 */
public class Person implements Serializable {
    private String name;
    private Integer age;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
