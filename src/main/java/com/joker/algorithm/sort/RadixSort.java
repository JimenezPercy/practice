package com.joker.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @Author: wzp
 * @Date: 2020/8/2 11:19
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] is = {8, 9,3, 12, 18, 56, 23, 1, 1, 9};

        sort(is, 10);
        System.out.println(Arrays.toString(is));
    }

    private static void sort(int[] is, int d) {
        //代表位数对应的数：1、10、100
        int n = 1;
        //保存每位排序后的结果，用于下一位排序的输入
        int index = 0;
        //数列长度
        int len = is.length;

        //10个桶：排序用的桶，用于保存每次排序后的结果
        //当前位上排序结果相同的数据放入同一个桶
        int[][] iss = new int[10][len];
        //用于保存每个桶里的元素个数
        int[] order = new int[len];

        while (n <= d) {
            //将数组的元素依次取出，放入对应的桶当中
            for (int i : is) {
                int di = (i / n) % 10;
                //在对应桶最后加上当前值
                iss[di][order[di]] = i;
                //桶里元素个数+1
                order[di]++;
            }
            //将前一个循环生成的桶里面的数据覆盖到原来的数组当中，保存结果
            for (int i = 0; i < len; i++) {
                if (order[i] != 0) {
                    //桶里由数据则从上往下遍历
                    for (int j = 0; j < order[i]; j++) {
                        is[index++] = iss[i][j];
                    }
                }
                //将桶里的计数归0
                order[i] = 0;
            }
            n *= 10;
            index = 0;
        }

    }

}
