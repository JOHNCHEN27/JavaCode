package com.lncanswer.thread.threadimpl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LNC
 * @version 1.0
 * @description Lock锁 --lock()开启锁  unlock()释放锁
 * @date 2023/9/24 9:31
 */
public class LockThread extends Thread{
    private static int ticket = 0;
    //创建Lock锁对象，Lock是一个接口，只能创建它的实现类对象ReentrantLock对象
    //需要加上静态static修饰，保证不同的线程公用这个锁
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock(); //开启锁
                if (ticket ==100){
                    //这里有一处bug 当ticket==100 进入这里跳出循环并没有把锁释放掉而是直接跳出循环
                    //用try-catch-finally来捕捉异常 实现最终获得锁
                     break;
                 }else {
                    Thread.sleep(10);
                     ticket++;
                     System.out.println(getName() + "正在卖第"  +ticket +"张票");
                 }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock(); //最终无论如何都会释放锁
            }
        }
    }
}
