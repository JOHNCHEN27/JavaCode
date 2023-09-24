package com.lncanswer.thread.threadtest.sumTest;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/24 14:21
 */
public class OddNumberThread1 implements Runnable{
    public int num = 1;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(OddNumberThread1.class) {
                if (num % 2 != 0 && num < 101) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                }
                if (num > 100) {
                    break;
                }
                num++;
            }
        }
    }
}
