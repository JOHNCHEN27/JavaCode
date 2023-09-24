package com.lncanswer.thread;

import com.lncanswer.thread.threadimpl.MyThread;

/**
 * @author LNC
 * @version 1.0
 * @description 出让线程（礼让线程）yield、插入线程/插队线程 join
 * @date 2023/9/23 18:52
 */
public class ThreadBaseMethod3 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * static void yield（） 出让线程/礼让线程
         * 表示出让CPU的执行权，由CPU重新选择线程来执行
         * 需要注意的是出让线程之后 CPU会重新选择线程，还是随机选择，可能还会选到此线程
         */

        /**
         *final void join() 插入线程/插队线程
         * 表示把此线程插入到当前执行的线程之前
         */
        MyThread t1 = new MyThread();
        t1.setName("haha");
        t1.start();
        //将t1线程插入到main线程之前
        t1.join();

        for (int i = 0; i < 10; i++) {
            System.out.println("main线程" + i);
        }
    }
}
