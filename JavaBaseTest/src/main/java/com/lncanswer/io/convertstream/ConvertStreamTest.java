package com.lncanswer.io.convertstream;

import java.io.*;

/**
 * @author LNC
 * @version 1.0
 * @description 转换流
 * @date 2023/9/22 10:41
 */
public class ConvertStreamTest {
    /**
     * 转换流是基本字节流和基本字符流的一种桥梁，本质上还是字符流 可以用来进行编码格式转换
     * 字符转换输入流：InputStreamReader,  字符转换输出流：OutputStreamWriter
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //创建转换流对象   在创建转换流对象的时候可以指定字符集
        InputStreamReader reader = new InputStreamReader(new FileInputStream("test.txt"),"UTF-8");
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("test1.txt"),"GBK");
        //JDK11可以使用基本字符流中的 charset方法来指定字符集

    }
}
