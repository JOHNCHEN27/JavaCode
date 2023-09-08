package com.lncanswer.colletionAdvanced.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/8 15:16
 */

public class ArrayListBase {
    /**
     * ArrayList底层是数组 （可以动态扩容） List有的方法它都有
     * 当创建一个空集合时，默认大小为0， 第一次添加元素时调用底层grow方法动态扩容 第一次扩容大小为10
     * 当后面集合满了之后 会再次调用grow方法进行扩容 扩容一个大小为原来大小的1.5倍的集合
     * 会把原来集合的元素全部添加到新集合中并且添加新元素 size++
     */
    public static void main(String [] args){
        List<String> list =new ArrayList<>();
    }
}
