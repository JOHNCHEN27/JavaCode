package com.lncanswer.thread.threadtest.sumTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/24 12:53
 */
public class GiftThread implements Runnable{
    //这里使用runnable接口来创建线程任务
    public  int gift = 100;  //初始化礼品数量为100

    //创建一个lock锁对象  这里不需要加static静态关键字是因为每个线程用的都是同一个GiftThread对象
    //它们的lock是一样的
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //使用lock手动加锁
                lock.lock();
                if (gift <10){
                    System.out.println("礼品小于十份，不再送出");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName() + "送出一份礼品,礼品剩余数量为:"+ --gift);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                //unlock方法手动释放锁 需要注意的是跳出循环时要释放掉锁
                lock.unlock();
            }
        }

    }
}
