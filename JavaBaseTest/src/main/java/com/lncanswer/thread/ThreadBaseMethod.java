package com.lncanswer.thread;

import com.lncanswer.thread.threadimpl.MyThread;

/**
 * @author LNC
 * @version 1.0
 * @description 线程基本方法
 * @date 2023/9/23 18:22
 */
public class ThreadBaseMethod {
    public static void main(String[] args) {
        /**
         * getName()  --返回此线程的名字
         * setName()  --为当前线程设置名字
         * 细节：每个线程默认有一个初始名字， 格式为：Thread-X(X表示序号，默认从0开始)
         * 如果要给线程设置名字，可以用set方法，也可以用构造方法设置
         * ---
         * Thread currentThread() --获取当前线程对象
         * 细节：当JVM虚拟机启动时，会自动创建多条线程，其中main线程就是调用main里面的方法去执行代码
         *---
         * void sleep(long time)  --让线程休眠指定时间，单位为毫秒
         * 细节：当哪条线程执行到这个方法，那么哪条线程就会停留相应的时间
         * 当时间到了之后，再继续执行下面的代码
         */

        //创建线程对象
        MyThread myThread  = new MyThread("线程1");
        MyThread myThread1 = new MyThread("线程2");

        //开启线程
        myThread.start();
        myThread1.start();
    }
}
