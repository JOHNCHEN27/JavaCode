package com.lncanswer.colletionAdvanced.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author LNC
 * @version 1.0
 * @description Conllections工具类
 * @date 2023/9/17 16:18
 */
public class CollectionsBase {

    /**
     * colletions不是集合，它是一个工具类
     * 常用Api:
     * 1、添加批量元素  public static <T> boolean addAll(Colletion<T>c, T...Elements)
     * 2、打乱List集合元素的顺序  public static void shuffle(List<?> list)
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //Collections工具类向集合中添加多个元素
        Collections.addAll(list,"sadas","ads","bvcb","kt","xczg","jbg");
        list.forEach(string ->System.out.println(string));
        //shuffle打乱顺序
        Collections.shuffle(list);
        for (String s : list) {
            System.out.print(s+ " ");
        }

    }
}
