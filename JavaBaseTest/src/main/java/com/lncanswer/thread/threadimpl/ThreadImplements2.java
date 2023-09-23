package com.lncanswer.thread.threadimpl;

import java.io.FilterOutputStream;

/**
 * @author LNC
 * @version 1.0
 * @description 多线程第二种实现方式
 * @date 2023/9/23 16:37
 */
public class ThreadImplements2 implements Runnable{
    /**
     * 定义一个类实现Runable接口并重写Run方法
     */
    @Override
    public void run() {
       //获取当前线程名称： 因为没有继承Thread类,getName方法只在Thread中存在，所有需要获取当前线程
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println(thread.getName() + " thread ");
        }

    }
}
