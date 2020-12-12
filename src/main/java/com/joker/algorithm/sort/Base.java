package com.joker.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

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

    public static int[] data(int num) {
        int[] data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = (int) ((Math.random() * 2 - 1) * num);
        }

        return data;
    }
}
