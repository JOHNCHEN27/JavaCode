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
        while ((b = reader.read()) != -1){
            System.out.print((char)b);
        }
        //释放资源
        accept.close();
        serverSocket.close();
    }
}
