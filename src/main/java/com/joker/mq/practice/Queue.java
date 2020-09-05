package com.joker.mq.practice;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author: wzp
 * @Date: 2020/9/5 10:03
 */
public class Queue {
    //队列
    private LinkedList<String> queue = (LinkedList<String>) Collections.synchronizedList(new LinkedList<String>());

    private final int MAX_QUEUE_SIZE = 10;

    /**
     * 往队列中添加消息
     * @param message
     */
    public synchronized void add(String message){

    }

    /**
     * 从队列中获取消息
     * @return
     */
    public synchronized String get(){
        return null;
    }

}
