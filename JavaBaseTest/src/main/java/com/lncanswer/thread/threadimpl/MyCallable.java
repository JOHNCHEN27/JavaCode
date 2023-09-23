package com.lncanswer.thread.threadimpl;

import java.util.concurrent.Callable;

/**
 * @author LNC
 * @version 1.0
 * @description 实现Callable接口
 * @date 2023/9/23 16:52
 */
public class MyCallable implements Callable<Integer> {
    //此处的泛型表示要返回结果的类型
    //重写Call方法
    @Override
    public Integer call() throws Exception {
        //求1-100之间的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum+=i;
        }
        return sum;
    }
}
