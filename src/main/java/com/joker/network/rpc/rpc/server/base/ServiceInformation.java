package com.joker.network.rpc.rpc.server.base;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 通用的通讯模型
 * @author wangzhipeng01
 * @date 2020-09-19 10:40
 */
@Data
public class ServiceInformation implements Serializable {
    private static final long serialVersionUID = -3788022550017085944L;

    /**
     * 被调用服务器的URL
     */
    private String  serviceUrl;

    /**
     * 被调用服务器端口
     */
    private int port;

    /**
     * 被调用的实现类
     */
    private String className;

    /**
     * 被调用的方法
     */
    private Method method;

    /**
     * 被调用的参数
     */
    private Object[] args;

    @Override
    public String toString() {
        return "ServiceInformation{" +
                "serviceUrl='" + serviceUrl + '\'' +
                ", port=" + port +
                ", className='" + className + '\'' +
                ", method=" + method +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
