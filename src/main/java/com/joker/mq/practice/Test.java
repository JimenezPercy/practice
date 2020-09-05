package com.joker.mq.practice;

import java.util.Collections;

/**
 * @author wangzhipeng01
 * @date 2020-09-05 14:58
 */
public class Test {
    public static void main(String[] args) {
        Queue queue=new Queue();

        //消费者
        new Thread(new Consumer(queue)).start();
        //生产者
        new Thread(new Producer(queue,2000)).start();

    }
}
