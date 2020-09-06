package com.joker.thread.pool;

import java.util.concurrent.*;

/**
 * 线程池测试类
 * @Author: wzp
 * @Date: 2020/9/6 7:57
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t =new Thread(new ThreadTest());
        Thread t1=new Thread(new ThreadScheduleTest());
        //固定大小的线程池
//        ExecutorService pool= Executors.newFixedThreadPool(2);
        //单任务线程池
//        ExecutorService pool= Executors.newSingleThreadExecutor();
        //可变长度线程池，一次性并发所有
//        ExecutorService pool= Executors.newCachedThreadPool();
        //延迟连接池
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(2);

        //线程延迟5秒执行
        pool.schedule(t1,3000, TimeUnit.MICROSECONDS);

        //自定义线程池
        //1.队列
//        BlockingQueue<Runnable> bqueue=new ArrayBlockingQueue<Runnable>(2);
        //2.自定义线程池
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,3,0,TimeUnit.MILLISECONDS,bqueue);
//        CallableThread cab=new CallableThread();
//        ExecutorService pool= Executors.newSingleThreadExecutor();
//        Future<String> result=pool.submit(cab);
//        System.out.println(result.get());
//
//        result=pool.submit(cab);
//        System.out.println(result.get());
//
//        result=pool.submit(cab);
//        System.out.println(result.get());
//
//        result=pool.submit(cab);
//        System.out.println(result.get());
//
//        result=pool.submit(cab);
//        System.out.println(result.get());

//        pool.execute(t);
//        pool.execute(t);
//
//        pool.execute(t);
//        pool.execute(t);
//
//        pool.execute(t);
//        pool.execute(t);
//
//        pool.execute(t);
//        pool.execute(t);
//
//        pool.execute(t);
//        pool.execute(t);
//
//        pool.execute(t);
//        pool.execute(t);
        pool.shutdown();
    }
}
