package com.lncanswer.thread.threadtest;

import com.lncanswer.thread.threadimpl.TicketThread2;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/23 20:18
 */
public class TicketTest2 {

    /**
     * 需求：电影院三个窗口卖100张票，对应三个线程来执行卖票
     * 使用同步方法完成
     * 同步方法：在方法修饰符之后加上synchronized关键字，表示此方法是同步方法
     */
    public static void main(String[] args) {
        //创建线程任务对象
        TicketThread2 t = new TicketThread2();
        System.out.println(t);

        //创建线程对象来执行线程任务
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
