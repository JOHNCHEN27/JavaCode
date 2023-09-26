package com.lncanswer.ipadderess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/26 10:53
 */
public class TCPAddressReceive {
    public static void main(String[] args) throws IOException {
        /**
         * TCP接受数据
         */
        //1、创建ServerSocker对象
        ServerSocket serverSocket = new ServerSocket(10000);

        //2、监听客户端的连接
        Socket accept = serverSocket.accept();

        //3、从连接通道中获取数据 字节流传递过来的数据不能处理编码问题使用转换流来进行转换
        //再利用缓冲流来提升效率
        BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        int b;
        //read方法会从连接通道里读取数据，直到读取到一个结束标记才会结束读取
        //如果没有结束标记，则一直循环等待读取
        while ((b = reader.read()) != -1){
            System.out.print((char)b);
        }
        accept.getOutputStream().write("已经成功接受到消息".getBytes());
        //释放资源
        accept.close();
        serverSocket.close();
    }
}
