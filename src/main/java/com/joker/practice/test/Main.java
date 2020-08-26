package com.joker.practice.test;

import com.joker.practice.service.List;
import com.joker.practice.service.impl.ArrayList;

/**
 * @author wangzhipeng01
 * @date 2020-07-29 16:59
 */
public class Main {
    public static void main(String[] args) {
        List list=new ArrayList();

        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        List list1=new ArrayList();

        list1.add("7");
        list1.add("7");
        list1.add("7");
        list1.add("7");

        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(3));
        list.add(3,list1);

        list.remove(3);
        list.remove(3);
        list.remove(3);
        list.remove(3);

        list.remove("5");

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
