package com.joker.thread.pool;

/**
 * @Author: wzp
 * @Date: 2020/9/6 9:16
 */
public class ThreadScheduleTest implements Runnable {
    public void run() {
        try {
            System.out.println("==================="+Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
