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
    private static final Integer DEF_TIME = 1000;
    private final String message;

    public Producer(final Queue queue) {
        this(queue, DEF_TIME);
    }

    public Producer(final Queue queue, final Integer time) {
        this(queue, time, "default message");
    }

    public Producer(final Queue queue, final Integer time, final String message) {
        this.queue = queue;
        this.time = time;
        this.message = message;
    }

    public void run() {
        //循环向队列添加消息
        int index = 0;
        try {
            while (true) {
                queue.add(Thread.currentThread().getName() + ' ' + this.message + ' ' + index++);
                //间隔指定时间，往队列中添加消息
                Thread.sleep(this.time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
