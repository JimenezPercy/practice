package com.joker.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: wzp
 * @Date: 2020/9/9 21:38
 */
public class ReadWriteTest {
    ReadWriteLock lock=new ReentrantReadWriteLock(false);
    //读
    public void readTest(){
        //获得读锁
        Lock readLock=lock.readLock();
        readLock.lock();
        System.out.println("获得读锁");
    }
    //写
    public void writeTest(){
        //获得写锁
        Lock writeLock=lock.writeLock();
        writeLock.lock();
        System.out.println("获得写锁");
        //获得读锁
        Lock readLock=lock.readLock();
        readLock.lock();
        System.out.println("重入读锁");
    }

    public static void main(String[] args) {
        ReadWriteTest test=new ReadWriteTest();

        new Thread(new Thread3(test)).start();
        new Thread(new Thread2(test)).start();
        new Thread(new Thread2(test)).start();

    }
}


class Thread2 implements Runnable {
    private final ReadWriteTest test;

    public Thread2(final ReadWriteTest test) {
        this.test = test;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        test.readTest();
    }
}

class Thread3 implements Runnable {
    private final ReadWriteTest test;

    public Thread3(final ReadWriteTest test) {
        this.test = test;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        test.writeTest();
    }
}