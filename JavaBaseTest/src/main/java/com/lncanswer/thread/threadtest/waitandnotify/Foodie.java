package com.lncanswer.thread.threadtest.waitandnotify;

/**
 * @author LNC
 * @version 1.0
 * @description 消费者
 * @date 2023/9/24 10:10
 */
public class Foodie extends Thread {

    @Override
    public void run() {
       while (true){  //指定锁对象
           synchronized(Desk.lock) {
               //判断是否还能吃
               if (Desk.count == 0){
                   break;
               }else {
                   //判断是否有食物
                   if (Desk.foodFlag ==0){
                       //没有食物则等待
                       try {
                           System.out.println("没有食物，等待生产");
                           Desk.lock.wait();  //调用lock锁绑定当前线程 进行等待
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }else {
                       //有食物则进行开吃
                       System.out.println("吃货正在吃第" + Desk.count + "碗面条");
                       Desk.count--;
                       //将桌子上的状态更改
                       Desk.foodFlag =0;
                       //唤醒生产者生产
                       Desk.lock.notifyAll(); //唤醒所有与这个锁绑定的等待线程
                   }
               }
           }
       }
    }
}
