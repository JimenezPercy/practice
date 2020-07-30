package com.joker.practice.test;

import com.joker.practice.service.impl.LinkedList;

/**
 * @Author: wzp
 * @Date: 2020/7/29 22:40
 */
public class Main {

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();

        ls.add("a");
        ls.add("b");
        ls.add("c");
        ls.add("d");
        ls.add("e");
        System.out.println(ls.size());
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
    }
}
