package com.joker.network.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wangzhipeng01
 * @date 2020-09-16 17:44
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        InetAddress ip=InetAddress.getByName("localhost");
        System.out.println(ip);
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
        System.out.println(InetAddress.getLocalHost());
    }
}
