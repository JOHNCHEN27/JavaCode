package com.lncanswer.io.printstream;

import java.io.*;

/**
 * @author LNC
 * @version 1.0
 * @description 打印流
 * @date 2023/9/22 17:01
 */
public class PrintStreamTest {
    /**
     * 打印流分为字节打印流、字符打印流
     * 有特有的写出方法，能保证数据的原样写出，可以实现自动换行自动刷新缓冲区等
     */
    public static void main(String[] args) throws IOException {
        /**
         * 字节打印流成员方法：write()最基本方法
         * println() --特有方法：打印任意数据，自动刷新缓冲区、自动换行
         * print()  --特有方法：打印任意数据,不换行
         * printf(String format,Object...args) 特有方法：带有占位符的打印语句,不换行
         */

        //创建字节打印流对象
        PrintStream printStream = new PrintStream(new FileOutputStream("text.txt"));
        //写出数据
        printStream.println(97); //原样写出数据 自动刷新缓冲区，自动换行
        printStream.print(true);
        printStream.printf("%s啦啦啦 %s","hh","haha");

        //释放资源
        printStream.close();

        //创建字符打印流对象
        PrintWriter printWriter = new PrintWriter(new FileWriter("text.txt",true));
        //写出数据
        printWriter.print(true);
        printWriter.println(100);
        printWriter.printf("%s啦啦啦 %s","hh","haha");
        //释放资源
        printWriter.close();
    }
}
