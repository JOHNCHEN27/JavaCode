package com.lncanswer.ipadderess;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author LNC
 * @version 1.0
 * @description 网络编程
 * @date 2023/9/26 8:53
 */
public class MyIpAddress {

    public static void main(String[] args) throws IOException {
        /**
         * static InetAddress getByName(String host) 确定主机名称的ip地址，可以是域名
         * String getHostName() 获取此IP地址的主机名
         * String getHostAddress() 返回文本显示中的Ip地址字符串
         */

        //获取InetAddress对象 IP地址对象
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //获取ip地址对应的主机名
        String hostName = address.getHostName();
        System.out.println(hostName);
        //获取IP对象对应的主机IP地址
        String hostAddress = address.getHostAddress();
        System.out.println(hostAddress);

        //UDP发送数据
       // testUDP();

        //聊天室发送数据
        charRoomSend();
    }



    /**
     * UDP协议发送、接受数据：创建DatagramSocket对象
     * 细节： 绑定端口，空参：所有可用的端口随机选择一个， 有参：指定端口
     */
    public static void testUDP() throws IOException {
        //创建对象
        DatagramSocket datagramSocket = new DatagramSocket();
        //打包数据
        String s = "nihaoa!";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        //发送数据
        datagramSocket.send(dp);
        //释放资源
        datagramSocket.close();

    }

    /**
     *聊天室发送数据，UDP发送数据直到输入数据是886，发送数据结束
     * UDP接受数据，因为不知道UDP发送数据什么时候截止，故采用死循环结束
     */
    public static void charRoomSend() throws IOException {
        //创建DatagramSocket对象
        DatagramSocket datagramSocket = new DatagramSocket();
        //键盘录入发送数据
        Scanner scanner = new Scanner(System.in);
        String s = getSendResult(datagramSocket, scanner);
        while (!s.equals("886")){
            System.out.println(".. s=" +s);
           s = getSendResult(datagramSocket,scanner);
        }
    }

    /**
     * 发送数据抽象方法
     * @param datagramSocket
     * @param scanner
     * @return
     * @throws IOException
     */
    private static String getSendResult(DatagramSocket datagramSocket, Scanner scanner) throws IOException {
        System.out.println("请输入数据：");
        String s = scanner.nextLine();
        System.out.println("s = " +s);
        byte[] bytes = s.getBytes();
        InetAddress address  = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        //发送数据包
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,address,port);
        datagramSocket.send(packet);
        return s;
    }

}
