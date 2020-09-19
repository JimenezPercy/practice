package com.joker.network.rpc.rpc;

import com.joker.network.rpc.rpc.server.base.ServiceInformation;
import com.joker.network.rpc.rpc.server.impl.NetServerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangzhipeng01
 * @date 2020-09-19 15:22
 */
public class RPCProxy implements InvocationHandler {

    //调用的服务类
    private Class<?> clazz;

    private ServiceInformation serviceInformation;

    /**
     * 组装serviceInformation
     * @param clazz
     * @param url
     * @param port
     * @return
     */
    public Object send(final Class<?> clazz,String url,int port){
        this.serviceInformation=new ServiceInformation();
        this.serviceInformation.setServiceUrl(url);
        this.serviceInformation.setPort(port);
        this.serviceInformation.setClassName(clazz.getName());

        return Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.serviceInformation.setMethod(method);
        this.serviceInformation.setArgs(args);
        return new NetServerImpl().send(this.serviceInformation);
    }
}
