package com.lncanswer.thread.threadtest.waitandnotify;

import sun.security.krb5.internal.crypto.Des;

/**
 * @author LNC
 * @version 1.0
 * @description 生产者（厨师）
 * @date 2023/9/24 10:06
 */
public class Cook extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                //判断消费者是否还能吃
                if (Desk.count ==0) {
                    System.out.println("你已经吃了十碗，不能再吃了");
                    break;
                }else {
                    //判断桌子上是否有食物
                    if (Desk.foodFlag == 0) {
                        //没有食物进行生产
                        Desk.foodFlag = 1;
                        System.out.println("厨师生产了" + Desk.foodFlag + "碗面条");
                        //唤醒锁中所有等待的线程
                        Desk.lock.notifyAll();
                    } else {
                        //有食物则进程等待
                        try {
                            System.out.println("还有食物，线程等待");
                            Desk.lock.wait(); //将当前线程与锁绑定，让线程等待
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            }
        }
    }
}
