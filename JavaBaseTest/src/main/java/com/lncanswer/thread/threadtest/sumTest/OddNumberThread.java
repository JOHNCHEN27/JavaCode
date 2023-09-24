package com.lncanswer.thread.threadtest.sumTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/24 13:11
 */
public class OddNumberThread implements Callable<List<Integer>> {
    //定义一个数字
    public int num = 1;
    //创建一共数组来存放数据
    public ArrayList<Integer> list = new ArrayList<Integer>();
    @Override
    public List<Integer> call() throws Exception {
        while (true){
            synchronized(OddNumberThread.class) {
                System.out.println(Thread.currentThread().getName()+"在存放数据");
                if (num % 2 != 0 && num < 101) {
                    //说明是奇数，存放到list当中
                    list.add(num);
                }
                if (num >100){
                    break;
                }
                num++;
            }
        }
        System.out.println("当前线程名字为：" +Thread.currentThread().getName());
        return list;
    }


}
