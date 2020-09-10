package com.joker.thread.lock;

/**
 * @Author: wzp
 * @Date: 2020/9/9 7:23
 */
public class Thread1 implements Runnable {
    private final LockTest test;

    public Thread1(LockTest test) {
        this.test = test;
    }

    public void run() {
        test.test();
    }
}
