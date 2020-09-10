package com.joker.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁
 *
 * @Author: wzp
 * @Date: 2020/9/9 7:20
 */
public class LockTest {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockTest test = new LockTest();
        Thread t1 = new Thread(new Thread1(test));
        t1.start();
        Thread t2 = new Thread(new Thread1(test));
        t2.start();
    }

    public void test() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        System.out.println("获得锁");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        lock.unlock();
        System.out.println("释放锁");
    }


}
