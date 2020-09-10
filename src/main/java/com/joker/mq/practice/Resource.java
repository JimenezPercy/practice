package com.joker.mq.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用锁重新实现生产者消费者模式，信号量
 *
 * @Author: wzp
 * @Date: 2020/9/10 6:52
 */
public class Resource {
    //当前资源数量
    private int num = 0;
    //当前资源上限
    private int maxSize = 10;
    //要操作的锁
    private Lock lock = new ReentrantLock();
    //锁的资源管理
    private Condition condition = lock.newCondition();

    public Resource() {

    }

    //可以指定资源上限
    public Resource(int maxSize) {
        this.maxSize = maxSize;
    }

    //消费资源
    public void sub() {
        try {
            //获得锁
            this.lock.lock();
            //资源消费殆尽
            while (num == 0) {
                //进入等待
                try {
                    System.out.println("消费殆尽，进入等待");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //消费资源
            this.num--;
            System.out.println(num);
            //唤醒其他线程（生产者）
            this.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            this.lock.unlock();
        }
    }

    //生产资源
    public void add() {
        try {
             //获得锁
            this.lock.lock();
            //资源满了以后，消费者等待
            while (num==maxSize){
                System.out.println("资源满，进入等待");
                this.condition.await();
            }
            num++;
            System.out.println(num);
            //唤醒消费者
            this.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }
}
