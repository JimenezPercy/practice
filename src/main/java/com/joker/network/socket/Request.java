package com.joker.network.socket;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangzhipeng01
 * @date 2020-09-17 17:46
 */
@Data
public class Request implements Serializable {


    private static final long serialVersionUID = 1888569482670543179L;

    private Integer id;
    private String name;
    private String message;

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
