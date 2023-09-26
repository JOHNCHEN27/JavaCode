package com.lncanswer.ipadderess;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LNC
 * @version 1.0
 * @description UDP聊天室
 * @date 2023/9/26 10:05
 */
public class UPDAddressRoom {
    public static void main(String[] args) throws IOException {
        /**
         * UDP方式接受聊天室数据 死循环接受
         */
        //从指定端口号接受数据
        DatagramSocket datagramSocket= new DatagramSocket(10086);

        byte [] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);

        while (true) {
            datagramSocket.receive(packet);
            //接受到的数据会存在字节数组中，解析数据
            InetAddress address = packet.getAddress();
            int length = packet.getLength();
            int port = packet.getPort();
            byte[] data = packet.getData();
            System.out.println("接受到数据：" + new String(data, 0, length) + "该数据是从 " + address + "这台电脑的" + port + "端口发送的");
        }
    }
}
