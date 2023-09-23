package com.lncanswer.thread.threadtest;

import com.lncanswer.thread.threadimpl.TicketThread;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/23 19:46
 */
public class ThreadTest {
    public static void main(String[] args) {
        /**
         * 需求：电影院买票，总共一百张，有三个线程同时买票
         * 当多个线程对同一数据进行操作时，会有不安全问题，比如数据的不正确
         * 所有需要对执行的代码进行加锁，使用synchronized（锁对象）进行加锁
         * synchronized使用之后，在有线程进入锁控制的代码块时，会自动关锁，防止其他线程进入代码块
         * 直到线程执行完毕，锁才会被释放
         */
        //创建线程对象
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        //开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}
