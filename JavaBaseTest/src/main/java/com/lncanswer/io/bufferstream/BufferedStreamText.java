package com.lncanswer.io.bufferstream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author LNC
 * @version 1.0
 * @description 缓冲流练习
 * @date 2023/9/22 10:01
 */
public class BufferedStreamText {

    public static void main(String[] args) throws IOException {
        BufferedStreamText bufferedStreamText = new BufferedStreamText();
        //测试基本流和缓冲流拷贝文件所用时间
        bufferedStreamText.testCopyFileTime();
    }


    /**
     * 四种方式拷贝文件，并统计各自用时
     */
    public void testCopyFileTime() throws IOException {
//        long testTime1Begin = System.currentTimeMillis();
//        //字节流基本流，一次读取一个字节
//        FileInputStream inputStream =new FileInputStream("test.txt");
//        FileOutputStream outputStream = new FileOutputStream("test1.txt");
//
//        //一次读取一个字节 一次读取一个1024字节数组
//        int a;
//        byte [] bytes = new byte[1024] ;
//        while ((a =inputStream.read(bytes)) !=-1){
//            outputStream.write(bytes,0,a);
//        }
//        //关闭资源
//        long testTimeEnd = System.currentTimeMillis();
//        outputStream.close();
//        inputStream.close();
//        System.out.println("最终用时: " + (testTimeEnd-testTime1Begin));


        //字节缓冲流
        long s1 = System.currentTimeMillis();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get("test.txt")));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("test1.txt",true));

        //读取数据
        int b;
        byte [] bytes = new byte[1024];
        while ((b = bufferedInputStream.read(bytes))!= -1){
            bufferedOutputStream.write(bytes,0,b);
        }
        //关闭流
        long s2 = System.currentTimeMillis();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println("最终用时: " + (s2-s1));



    }
}
