package com.lncanswer.io.bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author LNC
 * @version 1.0
 * @description 字节输出流 FileOutputStream
 * @date 2023/9/21 8:37
 */
public class ByteOutputStream {
    /**
     * 字节输出流使用步骤：
     * 创建对象、写出数据、释放资源
     * 细节：
     * 1、创建字节输出流对象时：参数是字符串表示的路径或者File对象都是可以的
     * 如果文件不存在，则会创建一个新的文件，但要保证父级路径存在，默认不写路径为当前项目路径
     * 如果文件存在，则会清空文件
     * 2、write方法的参数是整数，实际上写到本地文件的是整数对应的ASCII码字符
     * 3、释放资源，每次使用流对象之后需要释放资源，不然文件一直被占用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //创建字节输出流实现类对象
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //写入数据
        //fileOutputStream.write(97);

        //写入数据三种方式
        ByteOutputStream outputStream = new ByteOutputStream();
        outputStream.testByteOutputStream();

        //续写和换行
        outputStream.testByteOutputStream1();

        //释放资源
        fileOutputStream.close();

    }


    /**
     * 字节输出流写入数据三种方式：
     * write(int b ) -- 一次写入一个字节数据
     * write(byte [] b) -- 一次写入一个字节数组数据
     * write(byte [] b , int a, int c) 一次写入字节数组的部分数据
     * 第二个参数表示起始索引，从这开始，第三个参数表示取多少个数据
     */
    public void testByteOutputStream() throws IOException {
        //创建对象
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //写入数据
        byte [] bytes = {97,98,99,100};
       // fileOutputStream.write(bytes);

        //一次写部分数据 写前三个数据
        fileOutputStream.write(bytes,0,3);
        //释放资源
        fileOutputStream.close();
    }

    /**
     * 换行写：再次写一个换行符就可以了
     * windows: \r\n    Linux: \n    Mac: \r
     * 在windows操作系统中，java对回车进行了优化，回车符写\r或者\n都可以，底层会自动补全
     * 但是建议写全
     *
     * 续写： 在写入文件时，第二个参数表示续费开关，默认false，每次写的时候自动清空文件内容
     * 手动传递一个true，开启续写，当文件存在时，每次写入不会清空原来的数据
     */
    public void testByteOutputStream1() throws IOException {
        //创建对象 开启续写开关，设置第二个参数为true
        FileOutputStream outputStream = new FileOutputStream("test.txt",true);

        //换行写入： \r\n
        String s1 = "\r\n";
        byte[] bytes1 = s1.getBytes();
        outputStream.write(bytes1);

        //写入数据：如果需要写入字符串，要把字符串转会成字节数组
        String s = "哈哈";
        byte[] bytes = s.getBytes();
        outputStream.write(bytes);

        //释放资源
        outputStream.close();
    }
}
