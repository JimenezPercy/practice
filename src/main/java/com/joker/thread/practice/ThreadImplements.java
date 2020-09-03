package com.joker.thread.practice;

/**
 * @Author: wzp
 * @Date: 2020/9/2 22:28
 */
public class ThreadImplements implements Runnable {

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
