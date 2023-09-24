package com.lncanswer.thread.threadtest.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author LNC
 * @version 1.0
 * @description 生产者
 * @date 2023/9/24 10:55
 */
public class Cook extends Thread{
    //定义一个阻塞对象 不初始化
    ArrayBlockingQueue<String> queue;

    //定义一个构造方法，当创建线程时赋值
    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    /**
     * 阻塞队列底层存取数据的时候自动实现了加锁机制，不需要额外加锁，底层实现了消费者和生产者的
     * 阻塞和唤醒机制
     */
    @Override
    public void run() {
        while (true){
            try {
                //存放数据时判断队列是否满，满了会wait等待并且唤醒其他进程
                queue.put("面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("厨师放了一碗面条");
        }
    }
}
