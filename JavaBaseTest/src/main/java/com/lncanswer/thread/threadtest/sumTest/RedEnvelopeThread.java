package com.lncanswer.thread.threadtest.sumTest;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author LNC
 * @version 1.0
 * @description 抢红包
 * @date 2023/9/25 10:11
 */
public class RedEnvelopeThread implements Runnable{
    //设置红包大小为100
    public int redEnvelope = 100;
    //设置一个数表示红包的份数
    public int redEnvelopeNumber = 3;

    @Override
    public void run() {
        Random random = new Random();
        //格式化输出
        DecimalFormat format =new DecimalFormat("0.00");
       synchronized (RedEnvelopeThread.class) {
           if (redEnvelope > 0) {
               if (redEnvelopeNumber == 3) {
                   //将红包随机分成三份
                   redRandom(random, format);
               } else if (redEnvelopeNumber == 2) {
                   //剩余两份 继续随机分配红包
                   redRandom(random, format);
               } else {
                   System.out.println(Thread.currentThread().getName() + "抢到了" + format.format(redEnvelope)+ "元");
                   redEnvelope = 0;
               }
           } else {
               System.out.println(Thread.currentThread().getName() + "没抢到");
           }
       }

    }

    /**
     * 随机抽取红包
     * @param random
     * @param format
     */
    private void redRandom(Random random, DecimalFormat format) {
        Double i = random.nextDouble()* random.nextInt(redEnvelope) + 1;
        redEnvelope -= i;
        redEnvelopeNumber--;
        System.out.println(Thread.currentThread().getName() + "抢到了" + format.format(i)+ "元");
    }
}
