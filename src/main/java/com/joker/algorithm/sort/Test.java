package com.joker.algorithm.sort;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: wzp
 * @Date: 2020/12/11 22:05
 */
public class Test {

    public static void main(String[] args) {
        int[] data = Base.data(10000);
        long startTime = new Date().getTime();
        bubble(data);
        long endTime = new Date().getTime();
        System.out.println("执行时间：" + (endTime - startTime) + "ms");
    }



    /**
     * 冒泡
     * 执行时间：113ms
     * @param data
     */
    private static void bubble(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(data));
    }
}
