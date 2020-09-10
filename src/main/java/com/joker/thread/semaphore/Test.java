package com.joker.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Author: wzp
 * @Date: 2020/9/10 7:18
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //信号量
        Semaphore sp=new Semaphore(50);
        sp.acquire(25);
        System.out.println(1);
        sp.acquire(25);
        System.out.println(2);
        sp.release(30);
        System.out.println("release");
        sp.acquire(25);
        System.out.println(3);
    }
}
