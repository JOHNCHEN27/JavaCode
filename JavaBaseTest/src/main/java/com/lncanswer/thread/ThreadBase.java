package com.lncanswer.thread;

import com.lncanswer.thread.threadimpl.MyCallable;
import com.lncanswer.thread.threadimpl.ThreadImplements;
import com.lncanswer.thread.threadimpl.ThreadImplements2;
import org.omg.CORBA.INTERNAL;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LNC
 * @version 1.0
 * @description 多线程
 * @date 2023/9/23 16:15
 */
public class ThreadBase {
    /**
     * 进程：操作系统中每一个应用占用一个进程来运行应用程序
     * 线程：进程中的单位 ，一个进程有多个线程
     * 多线程：可以理解为一个进程中有多个事务在运行，一个事务对应一个进程
     * 并发：同一时刻，有多个指令在交替单个CPU上执行
     * 并行：同一时刻，有多个指令在CPU上同时运行
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程
        ThreadImplements threadImplements = new ThreadImplements();
        //setName方法可以为当前线程设置名称
        threadImplements.setName("线程1");
        //用start方法开启线程，如果用run方法的话仅仅只是调用了这个方法，线程并没有开启
        threadImplements.start();

        //第二种方式开启线程
         threadImple2();

        //第三种方式开启线程
        threadImpl3();

    }

    /**
     * 多线程的第二种实现方式：
     * 1、定义一个类实现Runnable接口，重写里面的Run方法
     * 2、创建此类的对象， 在创建一个Thread线程对象，并开启线程
     */
    public static void threadImple2(){
       //创建继续Runnable接口类对象，可以理解为创建一个任务
        ThreadImplements2 threadImplements2 = new ThreadImplements2();
        //创建线程开启这个任务执行
        Thread t1 = new Thread(threadImplements2);
        Thread t2 = new Thread(threadImplements2);
        //给线程设置名字
        t1.setName("线程2");
        t2.setName("线程3");

        //开启线程
        t1.start();
        t2.start();
    }

    /**
     * 多线程的第三种实现方式：
     * 1、创建一个类Mycalllable实现Callable接口
     * 2、重写Call（有返回值，类型为返回结果的类型）
     * 3、创建Mycallable对象，表示多线程要执行的任务
     * 4、创建FutureTask对象，来管理多线程运行的结果
     * 5、创建Thread类的对象，并启动线程执行任务
     */
    public static void threadImpl3() throws ExecutionException, InterruptedException {
        //创建自定义MyCallable类对象 表示任务
        MyCallable myCallable  = new MyCallable();
        //创建FutureTask对象，管理多线程执行的结果
        FutureTask<Integer> ft = new FutureTask<>(myCallable);
        //创建线程对象开启任务
        Thread thread  = new Thread(ft);
        thread.start();

        //获取多线程运行的结果
        Integer result = ft.get();
        System.out.println(result);
    }
}
