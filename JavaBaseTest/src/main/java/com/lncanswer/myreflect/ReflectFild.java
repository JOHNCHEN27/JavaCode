package com.lncanswer.myreflect;

import java.lang.reflect.Field;

/**
 * @author LNC
 * @version 1.0
 * @description 获取成员变量
 * @date 2023/9/26 20:49
 */
public class ReflectFild {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * Class类中用于获取成员变量的方法
         * Filed[] getFields() --返回所有公共成员变量数组(protect)
         * Field[] getDeclaredFields() --返回所有成员变量对象的数组
         * Field getField（String name）  --返回单个公共成员变量对象
         * Filed getDeclaredField(String name) --返回单个成员变量对象
         *
         * Field类创建对象方法
         * set(object obj,object value)  赋值
         * Object get(object obj)      获取值
         */
        //1、获取class字节码对象
        Class<?> aClass = Class.forName("com.lncanswer.myreflect.ReflectObject");

        //2、获取所有公共成员变量
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }
}
