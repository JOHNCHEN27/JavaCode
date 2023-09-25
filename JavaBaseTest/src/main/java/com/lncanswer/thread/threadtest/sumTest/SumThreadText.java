package com.lncanswer.thread.threadtest.sumTest;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LNC
 * @version 1.0
 * @description 多线程练习
 * @date 2023/9/24 12:39
 */
public class SumThreadText {
    /**
     * 多线程综合练习
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //多线程卖票
        //buyTicket();

        //送礼品
        //sendGift();

        //输出奇数
        //printOldNumber();
        //输出奇数第二种方式
      //  printOldNumber1();

        //抢红包
      //  robRedEnvelope();

        //抽取奖项
        extractJackpot();
    }


    /**
     * 一共一千张电影票，可以在两个窗口领取，假设每次领取的时间为3000毫秒
     * 用多线程模拟卖票过程并打印剩余电影票数量
     */
    public static void buyTicket(){
        TicketClass ticketClass = new TicketClass();
        TicketClass ticketClass1 = new TicketClass();

        ticketClass.setName("窗口1");
        ticketClass1.setName("窗口2");

        ticketClass.start();
        ticketClass1.start();

    }

    /**
     * 100份礼品，两个人同时发送，当剩余的礼品小于10份时则不再送出
     */
    public static void sendGift(){
        //创建线程任务
        GiftThread gift = new GiftThread();

        //创建线程对象来执行线程任务
        Thread t1 = new Thread(gift);
        Thread t2 = new Thread(gift);

        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();

    }

    /**
     * 同时开启两个线程，共同获取1-100之间的所有数字
     * 要求：输出所有的奇数
     */
    public static void printOldNumber() throws ExecutionException, InterruptedException {
        //创建线程任务
        OddNumberThread oddNumberThread = new OddNumberThread();
        //创建FutureTask管理结果
        FutureTask<List<Integer>> listFutureTask = new FutureTask<>(oddNumberThread);
        //创建线程
        Thread t1 = new Thread(listFutureTask);
        Thread t2 = new Thread(listFutureTask);

        //需要注意的是一个FutureTask只能够被执行一次，当线程再次调用这个对象时不会在执行call方法
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

        List<Integer> list = listFutureTask.get();
        System.out.println(list);
    }

    /**
     * 两个线程共享1-100的奇数的第二种方式
     */
    public static void printOldNumber1(){
        OddNumberThread1 oddNumberThread1 = new OddNumberThread1();
        //创建线程对象
        Thread t1 = new Thread(oddNumberThread1);
        Thread t2 = new Thread(oddNumberThread1);

        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }

    /**
     * 100块，分成三个包，现在有五个人去抢，红包是共享数据，五个人是五条线程
     */
    public static void robRedEnvelope(){
        RedEnvelopeThread redEnvelopeThread  = new RedEnvelopeThread();
        //创建五条线程
        Thread t1 = new Thread(redEnvelopeThread);
        Thread t2 = new Thread(redEnvelopeThread);
        Thread t3 = new Thread(redEnvelopeThread);
        Thread t4 = new Thread(redEnvelopeThread);
        Thread t5 = new Thread(redEnvelopeThread);

        t1.setName("甲");
        t2.setName("乙");
        t3.setName("丙");
        t4.setName("丁");
        t5.setName("戊");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


    /**
     * 抽奖箱抽奖，一个抽奖池，两个抽奖箱
     */
    public static void extractJackpot(){
        //创建奖项任务
        ExtractJackpot extractJackpot = new ExtractJackpot();

        //创建线程执行任务
        Thread t1 = new Thread(extractJackpot);
        Thread t2 = new Thread(extractJackpot);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");
        t1.start();
        t2.start();

    }
}
