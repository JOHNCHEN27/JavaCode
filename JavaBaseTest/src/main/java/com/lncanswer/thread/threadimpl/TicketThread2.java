package com.lncanswer.thread.threadimpl;

import com.lncanswer.thread.threadtest.TicketTest2;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/23 20:19
 */
public class TicketThread2 implements Runnable{
    //定义一个参数来表示票数
    int ticket = 0;  //这里不需要使用static修饰，因为我们是创建了一个线程任务，只会创建一次

    @Override
    public void run() {
        while (true){
            //synchronized加锁  用此类的字节码作为锁对象，因为每个类的字节码是唯一的
            if (synchronizedMehtod()) break;
        }

    }

    //同步方法 在方法修饰符之后加上synchronized关键字 锁对象为this 如果是静态方法锁对象为类字节码
    //此处的this指针是当前类对象的指针
    private  synchronized boolean synchronizedMehtod() {
        System.out.println(this);
            if (ticket ==100){
                return true;
            }else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ticket++;
                System.out.println(Thread.currentThread().getName() + "正在卖第" +ticket +"张票");
            }
        return false;
    }
}
