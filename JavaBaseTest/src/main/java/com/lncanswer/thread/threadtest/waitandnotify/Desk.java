package com.lncanswer.thread.threadtest.waitandnotify;

/**
 * @author LNC
 * @version 1.0
 * @description 中间者(桌子) --表示调用生产者和消费者(可理解为Cpu调用)
 * @date 2023/9/24 10:06
 */
public class Desk {
    //设置吃的总数 最多吃十碗
    public static int count =10;
    //设置桌子状态 是否有食物
    public static int foodFlag = 0;

    //设置锁对象 让多个线程对应一把锁
    public static Object lock = new Object();

}
