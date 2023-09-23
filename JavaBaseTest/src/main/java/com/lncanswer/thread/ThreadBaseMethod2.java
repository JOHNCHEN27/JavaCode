package com.lncanswer.thread;

import com.lncanswer.thread.threadimpl.MyThread;

/**
 * @author LNC
 * @version 1.0
 * @description 守护线程（备胎线程）
 * @date 2023/9/23 18:47
 */
public class ThreadBaseMethod2 {
    public static void main(String[] args) {
        /**
         * final void setDaemon(boolean on) 设置守护线程
         * 细节：当非守护线程执行完毕之后，守护线程也随之结束
         * 如：当线程1执行完毕，系统会告诉守护线程线程1执行完毕，守护线程没有在执行的必要
         * 随之守护线程也会自动停止
         */
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");

        //开启线程2为守护线程
        t2.setDaemon(true);
        //当线程1（非守护线程）执行完毕，守护线程会停止
        t1.start();
        t2.start();
    }
}
