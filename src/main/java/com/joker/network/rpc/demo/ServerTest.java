package com.joker.network.rpc.demo;

import com.joker.network.rpc.rpc.server.NetServer;
import com.joker.network.rpc.rpc.server.impl.NetServerImpl;

/**
 * @Author: wzp
 * @Date: 2020/9/18 7:34
 */
public class ServerTest {
    public static void main(String[] args) {
        NetServer server=new NetServerImpl();

        server.recv(9999);
    }
}
