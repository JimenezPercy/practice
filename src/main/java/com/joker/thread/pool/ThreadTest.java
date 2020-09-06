package com.joker.thread.pool;

/**
 * @Author: wzp
 * @Date: 2020/9/6 7:56
 */
public class ThreadTest implements Runnable{
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
