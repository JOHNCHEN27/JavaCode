package com.lncanswer.thread.threadtest.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/24 11:00
 */
public class Foodie extends Thread{
    //定义一个阻塞队列 不初始化
    ArrayBlockingQueue<String> queue;

    //提供一个构造方法为阻塞对象赋值
    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            //不断从阻塞队列获取面条
            try {
                String take = queue.take();
                System.out.println("吃货取到了" +take);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
