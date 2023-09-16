package com.lncanswer.colletionAdvanced.collection.set;

import com.lncanswer.entity.Student;

/**
 * @author LNC
 * @version 1.0
 * @description HashSet 集合
 * @date 2023/9/10 20:54
 */
public class HashSet {
    /**
     * 底层采用哈希表存储数据：哈希表是一种增删查改性能都较好的数据结构
     * 底层：数组+链表+红黑树
     * 哈希值 参考数据结构中的哈希查找
     * 1、如果没有重写hashCode方法，计算出的哈希值是不一样的，因为默认是用每个对象的地址值作为hash值
     * 2、如果已经重写hashCode方法，不同的对象只要属性值相同，计算出来的哈希值是一样的
     * 3、在小部分概率下，不同的属性值或者不同的地址值计算出来的哈希值也可能是一样的（哈希冲突）
     * HashSet：无序、不重复、无索引
     */
    public static void main(String [] args) {

        Student s1 = new Student("张三", 20);
        Student s2 = new Student("wuwu", 20);

        //如果重写了hashCode方法 不同的对象只要属性值相同.计算出来的哈希值就是一样的
        //没用重写hashCode 不同的对象计算出的哈希值是不同的
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        //在小部分的情况下， 不同属性值或者不同的地址值计算出来的哈希值也有可能是一样的
        //这种情况叫做哈希碰撞
        System.out.println("abc".hashCode());  //96354
        System.out.println("acD".hashCode());  //96354

        //如果存储的是自定义对象，一定要重写hashCode和equal方法 保证数据去重机制

    }

}
