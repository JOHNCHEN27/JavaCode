package com.lncanswer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //lamnda表达式
        //定义一个数组并存储一些字符串，利用Arrays中的sort方法进行排序
        //要求：安装字符串的长度进行排序，短的在前面，长的在后面
        String [] arr = {"qwe","wqeeqw","yyeea","ogcdadsa"};
        //如果要把数组中数据按照指定的方式进行排列，就需要用到sort方法，而且要指定排序规则
        Arrays.sort(arr,(String o1, String o2)->{
             return o1.length()-o2.length();
        });
        System.out.println(Arrays.toString(arr));

        //lambda表达式如果返回值只有一行 大括号 分号 return 三个可以同省略
        Arrays.sort(arr, (o1,o2) -> o2.length()-o1.length());

        System.out.println(Arrays.toString(arr));
    }
}