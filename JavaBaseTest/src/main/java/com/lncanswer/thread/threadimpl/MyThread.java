package com.lncanswer.thread.threadimpl;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/23 18:24
 */
public class MyThread extends Thread{
    //重写构造方法，使此类对象可以通过构造方法设置线程名称
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //getName可以获取此线程的名字
            System.out.println(getName() + " thread ");
        }
    }


}
