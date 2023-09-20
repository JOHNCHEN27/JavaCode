package com.lncanswer.function;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author LNC
 * @version 1.0
 * @description 方法引用
 * @date 2023/9/20 12:24
 */
public class FunctionDemo {

    /**
     * 1、引用处必须是函数式接口     2、引用的方法已经存在
     * 3、被引用方法的形参和返回值需要跟抽象方法的形参和返回值保持一致
     * 4、被引用的方法的功能需要满足当前的要求
     * :: 表示方法引用符
     * @param args
     */
    public static void main(String[] args) {
        //把已经存在的方法直接拿过来使用，引用格式：类名::方法名
        FunctionDemo functionDemo = new FunctionDemo();

        //方法引用 - 引用静态方法
        functionDemo.testStatic();

    }

    /**
     * 引用静态方法
     * 引用处必须是函数式接口 方法必须是静态的
     */
    public void testStatic(){
        //引用静态方法：  类名::方法名
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");
        //引用Integer的静态方法 转换数据类型
        list.stream().map(Integer::parseInt).forEach(s -> System.out.println(s));
    }

    /**
     * 引用成员方法： 对象::成员方法
     * 1、其他类： 其他类对象::方法名
     * 2、本类： this::方法名
     * 3、父类:  super::方法名
     */


    /**
     * 引用构造方法：
     * 格式：类名::new
     * 范例：Student::new
     */

    /**
     * 类名引用成员方法：需要注意的是只能够引用本类中的成员方法
     */

    /**
     * 数组的类型，需要跟流中数据的类型保持一致
     */
}
