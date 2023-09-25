package com.lncanswer.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LNC
 * @version 1.0
 * @description 线程池
 * @date 2023/9/25 15:53
 */
public class MyThreadPool {
    /**
     * 线程池用来存放线程，实现线程的复用
     * static ExecutorService newCachedThreadPool() --创建一个没有上限的线程池
     * static ExecutorService newFixedThreadPool()  --创建有上限的线程池
     * 当线程池中的线程不够用时，执行任务时将会等待线程任务空闲
     * 当线程池中的线程执行完成之后，又回到线程池中变成空闲状态
     */
    public static void main(String[] args) {
        //创建线程池对象 当没有指定线程池大小时每提交一个任务创建一个线程
        ExecutorService pool = Executors.newCachedThreadPool();

        //提交任务 --创建线程池任务对象
        pool.submit(new MyRunnableThread());
        pool.submit(new MyRunnableThread());

        //默认情况下线程池创建之后不会销毁
        //pool.shutdown();



    }
}
