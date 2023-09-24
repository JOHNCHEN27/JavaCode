package com.lncanswer.thread.threadtest;

import com.lncanswer.thread.threadimpl.LockThread;

/**
 * @author LNC
 * @version 1.0
 * @description Lock锁
 * @date 2023/9/24 9:30
 */
public class LockTest {
    public static void main(String[] args) {
        /**
         * 电影院卖票，用lock锁实现
         * Lock的是一个接口，只能够创建他的实现类对象ReentrantLock
         * lock()开锁、unlock()释放锁
         */
        LockThread t1 = new LockThread();
        LockThread t2 = new LockThread();
        LockThread t3 = new LockThread();

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();

    }
}
