package com.joker.algorithm.sort;

/**
 * @Author: wzp
 * @Date: 2020/8/1 20:51
 */
public class Base {

    public static int[] is = {8, 3, 12, 18, -56, 23, 1, -1, 9};

    public static void swap(int[] is, int a, int b) {
        int temp = is[a];
        is[a] = is[b];
        is[b] = temp;
    }
}
