package com.joker.thread.pool;

import java.util.concurrent.Callable;

/**
 * @Author: wzp
 * @Date: 2020/9/6 10:05
 */
public class CallableThread implements Callable<String> {
    public String call() throws Exception {
        return Thread.currentThread().getName()+" 返回的内容";
    }
}
