package com.lncanswer.io.bufferstream;

import java.io.*;

/**
 * @author LNC
 * @version 1.0
 * @description 缓冲流
 * @date 2023/9/22 9:17
 */
public class BufferedStreamDemo {

    /**
     * 缓冲流：是高级流，底层还是基本流（字节流、字符流），将基本流封装起来并增加了一些功能
     * 为基本流增加了缓冲区功能,类型：缓冲字节流、缓冲字符流
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //创建缓冲流对象
//        BufferedInputStream bis  = new BufferedInputStream(new FileInputStream("test.txt"));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test1.txt"));
//
//        //读取数据并拷贝
//        int b;
//        while ((b = bis.read()) != -1){
//            bos.write(b);
//        }
//        //释放资源，先开后关
//        bos.close();
//        bis.close();

        //字符缓冲流
        BufferedStreamDemo streamDemo = new BufferedStreamDemo();
        streamDemo.charBufferedStream();

    }

    /**
     * 字符缓冲流：除了基本字符流的方法之外，有固定的两个特有方法
     * 字符缓冲输入流： String readline() 读取一行数据，如果没有数据可读，直接返回null
     * 字符缓冲输出流： void newLine() 跨平台换行
     */
    public void charBufferedStream() throws IOException {
        //创建字符缓冲输入流、输出流
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("test1.txt"));
        //读取数据 遇到换行符不会读取
        String line;
        while ((line =reader.readLine()) !=null){
            //读取的数据写入
            writer.write(line);
            writer.newLine();
        }
        //关闭流， 只需关闭缓冲流，底层的基本流底层会一起关闭
        writer.close();
        reader.close();

    }
}
