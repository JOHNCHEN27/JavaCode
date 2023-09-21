package com.lncanswer.exception;

import java.util.Scanner;

/**
 * @author LNC
 * @version 1.0
 * @description 异常练习
 * @date 2023/9/20 16:49
 */
public class ExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                //输入姓名
                System.out.print("请输入姓名： ");
                String name = scanner.next();
                //输入年龄
                System.out.print("请输入年龄：");
                Integer age = scanner.nextInt();
                if (name.length() < 3 || name.length() > 10) {
                    throw new RuntimeException();
                }else if (age <18 || age >40){
                    throw new RuntimeException();
                }
                break;
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("姓名长度或年龄超出范围，请重新录入");
            }
        }
        System.out.println("执行");
    }
}
