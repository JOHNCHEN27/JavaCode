package com.lncanswer.myreflect;

/**
 * @author LNC
 * @version 1.0
 * @description 反射
 * @date 2023/9/26 20:13
 */
public class MyReflect {
    /**
     * 反射就是对类中的属性、成员方法、构造方法进行编程访问
     * 可以获取到一个类中的所有内容
     */
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 获取class对象的三种方式:
         * 1、Class.forName("全类名")  这里的全类名指的是从包名开始到类名
         * 2、类名.class
         * 3、对象.getClass();
         */
        //第一种方式获取Class对象
        Class<?> aClass = Class.forName("com.lncanswer.myreflect.ReflectObject");
        System.out.println(aClass);

        //类名.class
        Class<ReflectObject> reflectObjectClass = ReflectObject.class;
        System.out.println(reflectObjectClass);

        //对象.getClass()
        ReflectObject r = new ReflectObject();
        Class<? extends ReflectObject> aClass1 = r.getClass();
        System.out.println(aClass1);
    }
}
