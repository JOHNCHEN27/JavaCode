package com.lncanswer.colletionAdvanced.collection;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @author LNC
 * @version 1.0
 * @description Colletion单列集合
 * @date 2023/9/7 17:20
 */
public class CollectionBase {
    /**
     * Colletion是所有单列集合的顶层接口（List、Set使它的实现类）
     * 由于它是一个接口，我们不能直接创建它的对象 为了学习里面的方法创建ArrayList对象
     * 方法: add、remove、clear、contains、isEmpty、Size
     */
    public static void main(String [] args) {
          Collection<String> collection = new ArrayList<>();

          //1、添加元素 add方法
          //细节：往List添加时，方法永远返回true 因为List中元素可以是重复的
          //往Set集合中添加时，当元素不存在时返回true  元素以及存在返回false 因为set中不允许重复
          collection.add("eee");
          System.out.println(collection);

          //2、clear方法 清空元素
          collection.clear();
          System.out.println(collection);

          //3、删除元素 remove
          //细节：因为Colletion里面定义的是共性的方法 不能通索引删除，只能通过元素对象删除
          //删除成功方法 返回一个True 删除失败返回false 元素不存在则删除失败
          System.out.println(collection.remove("eee"));

          //4、判断元素是否包含 contains
          //细节：底层是依赖equals方法进行判断是否存在的 默认是字符串类型
          //如果是自定义对象，需要在javabean中重写equals方法这样通过contains才能正确取到
          boolean result = collection.contains("eee");
          System.out.println(result);

          //5、判断集合是否为空 isEmpty
          System.out.println(collection.isEmpty());

          //6、获取集合的长度 Size
          System.out.println(collection.size());


        /**
         * colletion遍历的三种方式：iterator迭代器、增强for、lambda表达式
         * iterator迭代器：适用于遍历过程中需要删除元素
         * 增强for、lambda表达式：适用于仅仅是需要遍历元素时
         */


    }

}
