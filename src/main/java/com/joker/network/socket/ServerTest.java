package com.joker.network.socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 服务端
 * @Author: wzp
 * @Date: 2020/9/17 7:58
 */
public class ServerTest {
    public static void main(String[] args) throws Exception {
        //1.服务端建立服务
        ServerSocket server=new ServerSocket(9999);//请求端口
        //2.创建监听
        server.accept();
        System.out.println("请求已抵达");
    }
}
