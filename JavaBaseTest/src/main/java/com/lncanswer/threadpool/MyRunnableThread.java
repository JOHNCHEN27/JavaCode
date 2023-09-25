package com.lncanswer.threadpool;

/**
 * @author LNC
 * @version 1.0
 * @description 创建线程任务
 * @date 2023/9/25 16:01
 */
public class MyRunnableThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" +(i+1));
        }

    }
}
