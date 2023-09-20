package com.lncanswer.entity;

/**
 * @author LNC
 * @version 1.0
 * @description 演员实体类
 * @date 2023/9/20 10:31
 */
public class Actor {
    private String name;
    private Integer age;

    public Actor() {
    }

    public Actor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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
}
