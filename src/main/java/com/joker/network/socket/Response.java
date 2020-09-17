package com.joker.network.socket;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangzhipeng01
 * @date 2020-09-17 17:59
 */
@Data
public class Response implements Serializable {

    private static final long serialVersionUID = -5659555891023226696L;

    private Integer id;
    private String name;
    private String message;

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
