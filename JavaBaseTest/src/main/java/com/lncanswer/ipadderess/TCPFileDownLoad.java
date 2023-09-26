package com.lncanswer.ipadderess;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LNC
 * @version 1.0
 * @description 通信练习
 * @date 2023/9/26 15:54
 */
public class TCPFileDownLoad {
    /**
     * 接受客服端上传的文件 --TCP方式  上传之后给出反馈
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        //接受文件 建立连接通道
        Socket acceptSocket = serverSocket.accept();

        //接受数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
        //将接受的数据上传到文件中
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("text1.txt")));
        int length;
        char[] bytes = new char[1024];
        while ((length = reader.read(bytes))!= -1){
            writer.write(bytes,0,length);
        }

        //发送反馈
        acceptSocket.getOutputStream().write("成功接受到文件".getBytes());

        //释放资源
        writer.close();
        reader.close();
        acceptSocket.close();
        serverSocket.close();




    }
}
