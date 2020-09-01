package com.joker.reflect.practice;

import java.lang.reflect.Constructor;

/**
 * @Author: wzp
 * @Date: 2020/8/29 7:54
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Person p = new Person();

        //获取类
        Class<?> clazz = p.getClass();

        //使用默认的空参构造来创建对象
//        Object obj1=clazz.newInstance();
//        System.out.println(obj1)
        //获取指定的构造来创建对象
        //获取所有可见构造
//        Constructor[] constructors1=clazz.getConstructors();
//        System.out.println(constructors1.length);
        //获取所有构造
//        Constructor[] constructors2=clazz.getDeclaredConstructors();
//        System.out.println(constructors2.length);

        //获取指定参数构造
//        Constructor constructor1 = clazz.getConstructor(String.class,Integer.class);
        Constructor constructor2 = clazz.getDeclaredConstructor(String.class);
        constructor2.setAccessible(true);
        Object obj=constructor2.newInstance("WZP");
        System.out.println(obj);
//        System.out.println(constructor2);


        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getPackage());
    }
}
