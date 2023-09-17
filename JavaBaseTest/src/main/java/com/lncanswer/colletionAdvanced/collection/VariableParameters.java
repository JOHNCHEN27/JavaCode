package com.lncanswer.colletionAdvanced.collection;

/**
 * @author LNC
 * @version 1.0
 * @description 可变参数
 * @date 2023/9/17 16:07
 */
public class VariableParameters {
    /**
     * 可变参数：方法的形参个数是可以变化的
     * 格式： 属性类型...形参名
     * 本质上是用一个数组来接受传递过来的参数
     */
    public static void main(String[] args) {
        VariableParameters var = new VariableParameters();
        int sum = var.getSum(1,2,3,4,5);
        System.out.println(sum);

    }

    /**
     * 可变参数小细节：
     * 1、在方法的形参中最多只能写一个可变参数
     * 2、如果还有其他参数，那么可变参数一定要写在最后面，因为可变参数放在第一位会将所有传递
     * 过来的参数接受，导致后面的参数没有数据可以接受
     * @param args
     * @return
     */
    public int getSum(int...args){
        //可变参数来接受传递的数据 本质上是创建了一个数组来接受数据
        int sum = 0;
        for (int arg : args) {
            sum+=arg;
        }
        return sum;
    }
}
