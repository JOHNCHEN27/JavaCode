package com.lncanswer.thread.threadtest.sumTest;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/24 12:41
 */
public class TicketClass extends Thread{
    //定义一个静态变量来表示剩余票数
    public static int ticket = 1000;

    //创建一个静态锁对象 使多个线程对应一把锁
    public static Object lock = new Object();
    @Override
    public void run() {

        while (true){
            //使用synchronized加锁
            synchronized(lock){
                if (ticket ==0){
                    //票数为0跳出
                    break;
                }else {
                    //卖出一张票
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket--;
                    System.out.println(getName() +"已经成功卖出一张票，剩余票数:" + ticket);
                }
            }
        }
    }
}
