package com.joker.thread.practice;

/**
 * @Author: wzp
 * @Date: 2020/9/3 7:36
 */
public class ThreadLockTest {
    public static void main(String[] args) {
        for(int i=0;i<10000;i++){
            new ThreadTest1().start();
        }
//        for(int i=0;i<10000;i++){
//            new Thread(new ThreadTest2()).start();
//        }
    }
}

class ThreadTest1 extends Thread{

    public void run() {
        System.out.println(Thread.currentThread().getName());
        Test.getTest().add();
    }
}

class ThreadTest2 implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName());
        Test.getTest().add();
    }
}

class Test{
    private static Test t=new Test();
    private Test(){}

    public synchronized static Test getTest(){
        return t;
    }
int i=0;
    public void add(){

        System.out.println(++i);

    }

    public void sub(){
        System.out.println(--i);
    }
}
