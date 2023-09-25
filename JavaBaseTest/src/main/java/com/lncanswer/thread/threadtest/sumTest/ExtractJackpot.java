package com.lncanswer.thread.threadtest.sumTest;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LNC
 * @version 1.0
 * @description 抽奖池抽奖
 * @date 2023/9/25 11:20
 */
public class ExtractJackpot implements Runnable{
    //定义一个变量设置抽奖池奖项
    ArrayList<Integer> list = new ArrayList<>();

    //创建一个lock锁对象
    Lock lock = new ReentrantLock();

    //空参构造为属性赋值
    public ExtractJackpot(){
        Collections.addAll(this.list,10,5,20,50,100,200,500,800,300,700);
    }

    @Override
    public void run() {
        Random r  = new Random();
        while (true){
            lock.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           if (list.size() != 0){
                //列表不为空，随机抽取奖项
                int i = r.nextInt(list.size());
                System.out.println(Thread.currentThread().getName() + "又产生了一个" + list.get(i) +"元大奖");
                list.remove(i);
            }else {
               lock.unlock();
               break;
           }
           lock.unlock();
        }
    }
}
