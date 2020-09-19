package com.joker.network.rpc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 在业务服务器上作为参数或者返回值的实例
 * @Author: wzp
 * @Date: 2020/9/19 8:24
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8921783783033831015L;
    private Integer id;
    private String username;
    private String password;
}
