package com.joker.algorithm.sort;

/**
 * 冒泡排序
 *
 * @Author: wzp
 * @Date: 2020/7/31 21:47
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] is = {8, 3, 12, 18, -56, 23, 1, -1, 9};

        for (int i = 0; i < is.length - 1; i++) {
            for (int j = 0; j < is.length - i - 1; j++) {
                if (is[j] > is[j + 1]) {
                    int temp = is[j];
                    is[j] = is[j + 1];
                    is[j + 1] = temp;
                }
            }
        }

        for(int t:is){
            System.out.println(t);
        }
    }
}
