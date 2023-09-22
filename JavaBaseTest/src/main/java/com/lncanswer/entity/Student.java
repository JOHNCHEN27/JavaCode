package com.lncanswer.entity;


import java.io.Serializable;
import java.util.Objects;

/**
 * 实现序列化接口，表示此类的对象可以被序列化写入文件中，
 * 序列化表示对对象的内容进行加密，只有通过反序列化才能读取对象
 * 需要指定类的序列化号唯一，否则当修改类的属性时，序列化号也会发生变化导致文件中的序列化号和
 * 程序中不一致，无法读取序列化对象
 */
public class Student  implements Serializable {

    //指定这个类的序列化号唯一 属性名称固定
    private static final long serialVersionUID =1L;
    private String name;
    //transient关键字 可以让属性不被序列化
    private transient int  age;


    /**
     * hashCode方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Student() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
