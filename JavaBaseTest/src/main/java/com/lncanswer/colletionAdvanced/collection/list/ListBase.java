package com.lncanswer.colletionAdvanced.collection.list;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author LNC
 * @version 1.0
 * @description  List集合
 * @date 2023/9/7 17:10
 */
public class ListBase {
    /**
     * List集合添加的元素是有序、重复、有索引的   像一条链一样
     * List是一个接口，不能直接创建它的对象，只能创建它的实现类的对象
     * colleciton单列集合中的所有方法都会被它的实现类继承
     * List独有的方法：
     * Void add(int index,E element) 在此集合中指定位置插入指定元素
     * E remove(int index) 删除指定位置的元素，返回被删除的元素
     * E set(int index,E element) 修改指定索引处的元素，返回被修改的元素
     * E get(int index) 返回指定索引处的元素
     */
    public static void main(String [] args){

        java.util.List<String> list = new ArrayList<>();
        list.add("qw");
        list.add("qwq");
        list.add("pp");

        //set修改元素
        list.set(1,"oioi");

        //除了colletion集合中三种遍历方式外 list独有普通for、列表迭代器遍历
        //列表迭代器在迭代器基础上追加了几个方法 如 add 可以用迭代器像集合中添加元素
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            String next = listIterator.next();
            System.out.println(next);
        }





    }

}
