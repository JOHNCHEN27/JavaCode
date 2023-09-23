package com.lncanswer.thread;

import com.lncanswer.thread.threadimpl.MyThread;

/**
 * @author LNC
 * @version 1.0
 * @description 线程调度方法--优先级
 * @date 2023/9/23 18:37
 */
public class ThreadBaseMethod1 {
    public static void main(String[] args) {
        /**
         * Java中默认的是抢占式调度方法（随机）
         * 设置线程的优先级：
         * setPriority(int newPriority)  --设置进程的优先级
         * final int getPriority()  --获取线程的优先级
         * 细节：优先级越高，抢到CPU的调度概率大，只是一个概率并不是百分比优先
         * 默认main线程的优先级为5
         */

        MyThread myThread1 = new MyThread("haha");
        MyThread myThread2 = new MyThread("wuwu");
        myThread1.setPriority(6);
        myThread2.setPriority(10);

        //开启线程
        myThread1.start();
        myThread2.start();


    }
}
