package com.lncanswer.io.charstream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author LNC
 * @version 1.0
 * @description 字符流
 * @date 2023/9/21 15:54
 */
public class charstream {

    /**
     * 字符流的底层： 字节流 + 字符流
     * 特点：输入流 遇到英文一次读取一个字节，遇到中文，一次读取多个字节
     * 输出流，底层会把数据按照指定的编码方式进行编码 ，变成字节在写到文件中
     * 适合用在对于纯文本文件进行操作
     * @param args
     */
    public static void main(String[] args) {
        //Reader、Writer接口，实现类加上File
        //创建字符输入流读取数据
        charstream chars = new charstream();

    }

    /**
     * 创建字符输入流读取数据，需要注意的是，读取数据的时候默认是按字节流方式一次读取一字节数据
     * 如果遇到中文会读取多个(GBK一次读取两个字节，UTF-8一次读取三个字节)，读取完成之后会把数据解码成为十进制
     *
     */
    public void ReaderChars() throws IOException {
        //创建对象
        FileReader fileReader = new FileReader("test.txt");
        //读取数据
        int ch;
        while ((ch=fileReader.read())!=-1){
            System.out.println((char)ch);
        }
        //利用char数组读取数据
        char [] chars = new char [2];
        int len;
        while ((len =fileReader.read(chars)) != -1){
            //读取字符数组的数据时，会把读取到的数据进行char类型强转放到字符数组中，返回一个读取数据值
            System.out.println(new String(chars,0,len));
        }

        //释放资源
        fileReader.close();
    }


    /**
     * 字符输出流：写数据的方式多了字符串 ，可以将字符串写入，也可以一次写入一个
     * 也可以按照一个字符数组写入，需要注意的是整数写入的是十进制格式，会自动解码成相应的编码
     */
}
