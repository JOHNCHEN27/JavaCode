package com.lncanswer.ipadderess;

import jdk.jfr.events.SocketReadEvent;

import java.io.*;
import java.net.Socket;

/**
 * @author LNC
 * @version 1.0
 * @description TCP通信练习
 * @date 2023/9/26 13:36
 */
public class TCPFileUploadTest {
    public static void main(String[] args) throws IOException {
        //创建socket对象
        Socket socket = new Socket("127.0.0.1", 10000);
        //创建文件
        FileInputStream fileInputStream  = new FileInputStream("text.txt");
        OutputStream outputStream = socket.getOutputStream();

        byte [] bytes = new byte[1024];
        int length;
        while ((length = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,length);
        }
        fileInputStream.close();
        //给出一个写出结束标
        socket.shutdownOutput();

        //接受反馈
        InputStreamReader inputStream =new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = inputStream.read())!= -1){
            System.out.print((char) b);
        }

        //释放资源
        outputStream.close();
        socket.close();

    }
}
