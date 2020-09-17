package com.joker.network.rpc.demo;

import com.joker.network.rpc.rpc.RPC;
import com.joker.network.rpc.service.UserService;

/**
 * @Author: wzp
 * @Date: 2020/9/18 7:34
 */
public class ClientTest {
    public static void main(String[] args) {
        //客户端调用某个service的方法，不是直接调用该service的实现类，而是调用rpc的通用接口
        UserService service= (UserService) RPC.rpc(UserService.class,"127.0.0.1",9999);
    }
}
