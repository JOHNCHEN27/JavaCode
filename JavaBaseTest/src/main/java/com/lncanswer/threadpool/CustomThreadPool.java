package com.lncanswer.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LNC
 * @version 1.0
 * @description 自定义线程池
 * @date 2023/9/25 16:22
 */
public class CustomThreadPool {
    public static void main(String[] args) {
        /**
         * ThreadPoolExecutor threadPoolExecutor = new ...
         * 核心线程数量+临时线程数量+空闲线程最大存活时间+任务队列+创建线程工厂+任务的拒绝策略
         * 1、核心线程数量不能小于0
         * 2、最大线程数量不能小于或等于0
         * 3、空闲线程最大存活时间不能小于0
         * 4、时间单位用TimeUnit指定
         * 5、任务队列不能为空
         * 6、线程工厂不能为空
         * 7、任务的拒绝策略不能为空
         * 细节：当线程池满以及任务队列满的时候，还要任务进来就会创建临时线程来执行任务，
         * 在此基础上当临时线程也满了之后，就会执行任务拒绝策略
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3, //核心线程数量
                6, //最大线程数量
                60,//空闲线程最大存活时间
                TimeUnit.SECONDS, //时间单位
                new ArrayBlockingQueue<>(3), //等待任务队列
                Executors.defaultThreadFactory(), //创建线程工厂
                new ThreadPoolExecutor.AbortPolicy() //任务拒绝策略
        );

        //向自定义线程池中提交线程任务
        pool.submit(new MyRunnableThread());

        //关闭线程池
        pool.shutdown();
    }
}
