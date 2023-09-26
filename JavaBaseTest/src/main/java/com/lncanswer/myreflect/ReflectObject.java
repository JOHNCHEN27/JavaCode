package com.lncanswer.myreflect;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/26 20:18
 */
public class ReflectObject {
    private String name;
    protected String age;

    public String gender;

    public ReflectObject() {

    }

    public ReflectObject(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
