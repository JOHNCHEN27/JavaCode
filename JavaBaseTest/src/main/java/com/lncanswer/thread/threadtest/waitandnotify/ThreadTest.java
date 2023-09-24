package com.lncanswer.thread.threadtest.waitandnotify;

/**
 * @author LNC
 * @version 1.0
 * @description 生产者和消费者问题
 * @date 2023/9/24 10:04
 */
public class ThreadTest {
    /**
     * wait() --等待方法 等待某事物的发生
     * notify() --唤醒方法 唤醒相应的进程
     * notifyAll() --唤醒所有进程
     */
    public static void main(String[] args) {

        Cook cook = new Cook();
        Foodie foodie  = new Foodie();

        cook.start();
        foodie.start();

    }
}
