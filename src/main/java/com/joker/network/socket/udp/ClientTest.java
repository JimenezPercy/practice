package com.joker.network.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author: wzp
 * @Date: 2020/9/17 23:19
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        //直接发送无需响应，发送端口要与接收端口不一致
        DatagramSocket socket=new DatagramSocket(8888);
        //准备数据
        String str="this is udp message";
        //创建数据报
        DatagramPacket packet=new DatagramPacket(str.getBytes(),
                str.length(),
                InetAddress.getByName("127.0.0.1"),//获取IP地址
                9999);//端口
        socket.send(packet);
        System.out.println("已发送");
    }
}
