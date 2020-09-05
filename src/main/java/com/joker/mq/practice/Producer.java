package com.joker.mq.practice;

/**
 * 生产者
 *
 * @Author: wzp
 * @Date: 2020/9/5 10:06
 */
public class Producer implements Runnable {
    private final Queue queue;
    private final Integer time;
    private final Integer DEF_TIME = 1000;

    public Producer(){}

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public Producer(Queue queue, Integer time) {
        this.queue = queue;
        this.time = time;
    }

    public void run() {

    }
}
