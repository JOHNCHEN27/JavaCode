package com.lncanswer.ipadderess;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LNC
 * @version 1.0
 * @description UDP接受发送数据
 * @date 2023/9/26 9:16
 */
public class UDPAddress {
    public static void main(String[] args) throws IOException {
        /**
         * 创建DatagramSocket对象，可以指定端口表示用哪个端口发送数据，也可以不指定随机发送
         */
        DatagramSocket datagramSocket = new DatagramSocket(10086); //从10086端口接受数据

        //接受数据包
        byte [] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);

        //receive方法是阻塞的，程序执行到这一步会死等，等发送端发送消息
        datagramSocket.receive(packet);

        //解析数据包
        byte [] data = packet.getData();
        int len = packet.getLength();
        InetAddress address = packet.getAddress();
        int port = packet.getPort();

        System.out.println("接受到数据  " + new String(data,0,len));
        System.out.println("该数据是从 " +address + "这台电脑的" +port + "端口发送的");

        //释放资源
        datagramSocket.close();
    }
}
