package com.joker.mq.practice;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author: wzp
 * @Date: 2020/9/5 10:03
 */
public class Queue {
    //队列
    private LinkedList<String> queue =new LinkedList<String>();

    private int queueSize;
    private final static int MAX_QUEUE_SIZE = 10;

    public Queue() {
        this(MAX_QUEUE_SIZE);
    }

    public Queue(int queueSize) {
        //指定队列上限
        this.queueSize = queueSize;
    }

    /**
     * 往队列中添加消息
     * @param message
     */
    public synchronized void add(String message){
        //1.如果队列满了，就会进入阻塞状态
        while (this.queue.size()==this.queueSize){
            try {
                System.out.println("队列满了，进入等待~~~");
                //等待有消费者消费了消息
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //2.当队列没满的时候
        this.queue.addFirst(message);
        System.out.println("添加内容："+message);
        //3.唤醒进入等待状态的消费者
        this.notifyAll();

    }

    /**
     * 从队列中获取消息
     * @return
     */
    public synchronized String get(){
        //1.如果队列为空，即size为0时，没有资源了需要等待
        while (this.queue.size()==0){
            //jdk推荐使用while进行验证，防止虚假唤醒
            try {
                System.out.println("队列空了，进入等待~~~");
                //资源为0，进入等待状态；等待有新的资源加入
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //2.如果队列不空，即size不为0，那么获取资源
        //先进先出，获取队列末尾的消息
        String message=this.queue.getLast();

        //3.要将消息从队列中移除
        this.queue.removeLast();

        //4.唤醒其他现场等待的状态，生产者在将队列加满之后会等待，消费者消费完之后需要唤醒生产者，令其继续添加元素
        this.notifyAll();

        return message;
    }

}
