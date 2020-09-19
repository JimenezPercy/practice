package com.joker.network.rpc.service.impl;

import com.joker.network.rpc.entity.User;
import com.joker.network.rpc.service.UserService;

/**
 * @Author: wzp
 * @Date: 2020/9/18 7:31
 */
public class UserServiceImpl implements UserService {
    public User queryUserById(Integer id) {
        User user=new User();
        user.setId(1);
        user.setUsername("1111");
        user.setPassword("1111");
        System.out.println("服务端要返回的entity"+user.toString());
        return user;
    }
}
