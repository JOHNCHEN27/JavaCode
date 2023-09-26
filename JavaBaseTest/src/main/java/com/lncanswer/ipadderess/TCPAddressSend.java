package com.lncanswer.ipadderess;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author LNC
 * @version 1.0
 * @description TCP协议
 * @date 2023/9/26 10:49
 */
public class TCPAddressSend {
    public static void main(String[] args) throws IOException {
        /**
         * TCP协议发送数据
         */
        //1、创建Socket对象
        Socket socket = new Socket("127.0.0.1",10000);
        //2、可以从连接通道中获取输出流
        OutputStream outputStream = socket.getOutputStream();
        //写入数据
        outputStream.write("nihaohao哈哈哈哈".getBytes());
        //释放资源
        outputStream.close();
        socket.close();

    }
}
