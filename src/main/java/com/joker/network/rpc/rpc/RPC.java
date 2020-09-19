package com.joker.network.rpc.rpc;

/**
 * RPC框架
 * @Author: wzp
 * @Date: 2020/9/18 7:36
 */
public class RPC {
    /**
     *
     * @param clazz 请求的接口
     * @param url 请求的RPC服务器URL
     * @param port 请求的RPC服务器端口
     * @return
     */
    public static Object rpc(final Class<?> clazz,String url,int port){
        //通过动态代理，给对应接口一个代理类
        //这个代理类的目的是调用通讯类的send
        return new RPCProxy().send(clazz, url, port);
    }
}
