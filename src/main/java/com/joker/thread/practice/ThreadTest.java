package com.joker.thread.practice;

/**
 * @Author: wzp
 * @Date: 2020/9/2 22:28
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
//        Thread thread1=new ThreadExtends();
//        thread1.start();
//
//        Thread thread2=new Thread(new ThreadImplements());
//        thread2.start();


        Thread t1=new Thread(new ThreadImplements());
        t1.start();
        t1.join(100);
        Thread t2=new Thread(new ThreadImplements());
        t2.start();
        t2.join();
        Thread t3=new Thread(new ThreadImplements());
        t3.start();
        t3.join();
        Thread t4=new Thread(new ThreadImplements());
        t4.start();
        t4.join();
        Thread t5=new Thread(new ThreadImplements());
        t5.start();


    }
}
