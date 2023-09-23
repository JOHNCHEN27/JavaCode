package com.lncanswer.thread.threadimpl;

/**
 * @author LNC
 * @version 1.0
 * @description 线程的实现方式一： 定义一个类继承Thread类 重写run方法
 * @date 2023/9/23 16:25
 */
public class ThreadImplements extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //getName可以获取此线程的名字
            System.out.println(getName() + " thread ");
        }
    }
}
