package com.joker.thread.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wzp
 * @Date: 2020/9/4 21:48
 */
public class ThreadSecurityTest {

    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
    }
}
