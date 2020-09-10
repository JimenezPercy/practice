package com.joker.mq.practice;

import java.util.Collections;

/**
 * @author wangzhipeng01
 * @date 2020-09-05 14:58
 */
public class Test {
    public static void main(String[] args) {

//        //用队列实现
//        Queue queue=new Queue();
//
//        //消费者
//        new Thread(new Consumer(queue)).start();
//        //生产者
//        new Thread(new Producer(queue,2000)).start();

        //锁机制实现
        Resource resource = new Resource(3);
        new Thread(new c(resource)).start();
        new Thread(new p(resource)).start();
    }
}

class c implements Runnable {
    private final Resource resource;

    public c(final Resource resource) {
        this.resource = resource;
    }


    public void run() {
        //循环从队列中获取消息
        try {
            while (true) {
                Thread.sleep(1000);
                resource.sub();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class p implements Runnable {
    private final Resource resource;

    public p(final Resource resource) {
        this.resource = resource;
    }


    public void run() {
        //循环从队列中获取消息
        try {
            while (true) {
                Thread.sleep(1000);
                resource.add();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
