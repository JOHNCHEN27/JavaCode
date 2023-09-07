package com.lncanswer.colletionAdvanced.ergodic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author LNC
 * @version 1.0
 * @description lanbda表示式遍历集合
 * @date 2023/9/7 19:17
 */
public class Lambda {
    /**
     * lanbda表达式提供了一种更简单、更直接的遍历集合方式
     */
    public static void main(String [] args){
        Collection<String> collection = new ArrayList<>();
        collection.add("adf");
        collection.add("weq");

        //利用匿名内部类的形式
        //底层原理：循环遍历每一个元素 把得到的元素传给下面的accept方法 s表示集合中的每一个元素
        collection.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //lambda表达式 如果参数只有一个 类型可以省略 小括号可以省略
        //返回值如果只有一行 return、{}大括号、分号; 都可以省略
        collection.forEach(s -> System.out.println(s));

    }

}
