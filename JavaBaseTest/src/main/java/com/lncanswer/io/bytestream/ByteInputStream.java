package com.lncanswer.io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author LNC
 * @version 1.0
 * @description 字节输入流
 * @date 2023/9/21 12:26
 */
public class ByteInputStream {

    /**
     * 字节输入流 FileInputStream 读取不到数据返回-1
     * @param args
     * 细节：创建字节输入流对象时如果文件不存在直接报错，一次只能读一个字节，读出来的是ASCII码值
     * 读到文件末尾没有数据时返回-1，读取一次数据移动一次指针，指向后面一个数据
     */
    public static void main(String[] args) throws IOException {
        //创建FileInputeStream 字节输入流数据
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        //读取数据
        //int read = fileInputStream.read();
        //System.out.println(read);

        //循环读取数据：注意每次读取数据之后会移动指针
        int b ;
        while ((b = fileInputStream.read()) != -1){
            System.out.println(b);
        }

        //每次去读一个字节数组的数据 如：Byte[2] 读取的数据存储在数组中，返回值为读取数据的个数
        byte [] bytes = new byte[2];
        fileInputStream.read(bytes); //表示每次读取两个字节数组的数据，
        //释放资源
        fileInputStream.close();

    }
}
