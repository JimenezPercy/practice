package com.joker.network.rpc.service;

import com.joker.network.rpc.entity.User;

/**
 * @Author: wzp
 * @Date: 2020/9/18 7:30
 */
public interface UserService {
    public User queryUserById(Integer id);
}
