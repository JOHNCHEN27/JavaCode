package com.lncanswer.thread.threadimpl;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/23 19:47
 */
public class TicketThread extends Thread{
    static int ticket = 0;  //保证ticket票数不会被重新赋值为0
    //创建synchronized锁对象，并且保证这个对象是唯一,保证多个线程对应一个锁
    static Object object = new Object();
    @Override
    public void run() {
        while (true){
            //加锁，实现线程隔离，当有线程进入的时候，会自动将这块代码锁起来，不允许其他线程访问
            //直到线程出来，锁才会被释放，这种方式叫做同步代码块
            synchronized(object)
            {if (ticket <100){
                ticket++;
                System.out.println(getName() + "正在卖第" + ticket + "张票" );
            }else{
                break;
            }
        }}
    }
}
