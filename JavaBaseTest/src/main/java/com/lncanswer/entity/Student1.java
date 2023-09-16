package com.lncanswer.entity;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/16 17:54
 */
public class Student1 implements Comparable<Student1>{  //实现Comparable接口
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 实现Comparable接口
     * @param o the object to be compared.
     * @return
     */
    //返回值：
    //负数：表示当前要添加的元素是小的，存左边
    //正数：表示当前要添加的元素是大的，存右边
    //0：表示当前要添加的元素已经存在，舍弃
    @Override
    public int compareTo(Student1 o) {
        //this:表示要添加的元素
        //o：表示TreeSet红黑树中已经存在的元素

        //排序规则：只看年龄 按照年龄升序进行排列
        return this.getAge() -o.getAge();

        //每次比较之后要存的位置以及存在元素会再次调用compareTo方法再次比较 直到存入红黑树


    }
}
