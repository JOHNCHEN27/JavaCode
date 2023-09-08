package com.lncanswer.colletionAdvanced.ergodic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author LNC
 * @version 1.0
 * @description 增强for
 * @date 2023/9/7 19:09
 */
public class For {
    /**
     * 增强for底层就是iterator迭代器，为了简化迭代器书写的
     * 所有的单列集合和数组才能使用增强for进行遍历
     */
    public static void main(String [] args){
        Collection<String> collection = new ArrayList<>();
        collection.add("zhangsan");
        collection.add("lisi");
        collection.add("wangwu");

        //利用增强for进行遍历
        for (String s : collection) {
            //s只是一个第三方变量，每次遍历把集合中的元素放到s中，如果对s修改不会影响原来的数据
            System.out.println(s);
        }
    }
}
