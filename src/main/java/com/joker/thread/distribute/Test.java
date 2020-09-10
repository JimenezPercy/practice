package com.joker.thread.distribute;

import java.io.File;

/**
 * 分布式
 *
 * @Author: wzp
 * @Date: 2020/9/10 22:45
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new TestThread()).start();
        new Thread(new TestThread()).start();
        new Thread(new TestThread()).start();
        new Thread(new TestThread()).start();
    }
}

//独占锁
class TestThread implements Runnable {

    public void run() {
        File f = new File("d://testLock");
        while (true) {
            boolean flag = f.mkdir();
            if (flag) {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                break;
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        f.delete();
        System.out.println(Thread.currentThread().getName() + "释放锁");

    }
}
