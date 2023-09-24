package com.lncanswer.thread.threadtest.blockingqueue;

import java.text.CollationKey;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author LNC
 * @version 1.0
 * @description 阻塞队列
 * @date 2023/9/24 10:51
 */
public class BlockingQueue {
    /**
     * 阻塞队列：分为 数组阻塞队列(ArrayBlockQueue),链表阻塞队列(LinkBlockQueue)
     * 相对于定义一个队列，指定阻塞队列的大小，put()方法往里面放数据
     * take()方法往里面取数据
     */
    public static void main(String[] args) {
        /**
         * 阻塞队列底层实现了等待唤醒机制，当放数据的时候会判断队列是否为满，满了进行wait等待
         * 同时唤醒其他的所有线程，当取数据的时候会判断队列是否为空，空了会进行等待并唤醒其他线程
         * put、take 存取数据时底层会自动进行加锁来保证同一把锁对象
         */
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        //需要保证线程对应同一个阻塞队列
        Cook cook = new Cook(arrayBlockingQueue);
        Foodie foodie = new Foodie(arrayBlockingQueue);

        //开启线程
        cook.start();
        foodie.start();
    }
}
