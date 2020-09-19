package com.joker.network.rpc.rpc.server;

import com.joker.network.rpc.rpc.server.base.ServiceInformation;

/**
 * 网络通讯服务，框架自带
 * @author wangzhipeng01
 * @date 2020-09-19 10:22
 */
public interface NetServer {

    /**
     * 客户端发送请求到服务器
     * @return
     */
    Object send(ServiceInformation serviceInformation);
    /**
     * 指定端口启动服务端服务
     * @param port 端口号
     */
    void recv(int port);
}
