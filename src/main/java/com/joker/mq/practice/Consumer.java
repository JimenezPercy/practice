package com.joker.mq.practice;

/**
 * 消费者
 *
 * @Author: wzp
 * @Date: 2020/9/5 10:06
 */
public class Consumer implements Runnable {

    private final Queue queue;
    private final Integer time;
    private static final Integer DEF_TIME = 1000;

    public Consumer(final Queue queue) {
        this(queue, DEF_TIME);
    }

    public Consumer(final Queue queue, final Integer time) {
        this.queue = queue;
        this.time = time;
    }

    public void run() {
        //循环从队列中获取消息
        try {
            while (true) {
                String message=this.queue.get();
                //间隔指定时间从队列中获取
                Thread.sleep(this.time);
                System.out.println("消费内容："+message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
