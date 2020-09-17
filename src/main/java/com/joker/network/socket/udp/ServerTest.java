package com.joker.network.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author: wzp
 * @Date: 2020/9/17 23:19
 */
public class ServerTest {
    public static void main(String[] args) throws Exception {
        //创建
        DatagramSocket server=new DatagramSocket(9999);

        byte[] bytes=new byte[100];
        DatagramPacket pg=new DatagramPacket(bytes,bytes.length);

        while (true){
            //正式接收包
            server.receive(pg);
            //发送方地址
            System.out.println(pg.getAddress());
            //发送方端口
            System.out.println(pg.getPort());
            //数据
            System.out.println(new String(pg.getData(),0,100));
        }
    }
}
