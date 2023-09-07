package com.lncanswer.colletionAdvanced.ergodic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author LNC
 * @version 1.0
 * @description  迭代器遍历  ergodic意思为：遍历
 * @date 2023/9/7 17:51
 */
public class iterator {

    /**
     * 迭代器不依赖索引
     * 相关的三个方法：Iterator() 通过集合获取一个迭代器对象
     * hasNext():判断当前元素位置是否有元素 有返回true 没有返回false
     * Next():获取当前元素并移动指针到下一个位置
     * 创建迭代器对象的时候，默认从0开始 hasNext首先第一个元素开始判断
     */
    public static void main(String [] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("aaa");
        //collection.add("bbb");
        //collection.add("ccc");

        //利用iterator迭代器进行遍历,首先创建迭代器对象
        Iterator<String> iterator = collection.iterator();
        //遍历 hasNext判断当前位置是否有元素
        while (iterator.hasNext()){
            //如果有获取当前元素再把指针指向一下位置
            String next = iterator.next();
            System.out.println(next);
        }

        /**
         * 细节: next()方法在循环中只能使用一次
         * 迭代器遍历完成之后 指针不会复位
         * 如果没有元素强行取会报NoSuchElementException
         * 迭代器遍历时，不能用集合的方法进行增加或者删除
         */
    }
}
