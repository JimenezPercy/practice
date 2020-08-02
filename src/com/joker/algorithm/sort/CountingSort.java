package com.joker.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @Author: wzp
 * @Date: 2020/8/2 8:00
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] is = {8, 3, 12, 18, 6, 23, 1, 0, 21, 9};

        sort(is);
        System.out.println(Arrays.toString(is));
    }

    public static void sort(int[] is) {
        //获取数列的最大值和最小值
        int max = is[0];
        for (int i : is) {
            if (i > max) {
                max = i;
            }
        }
        //根据最大值确定数组的长度
        int[] temp = new int[max + 1];

        for (int i = 0; i < is.length; i++) {
            //temp数组的值用于保存每个数列的元素出现的次数
            temp[is[i]]++;
        }
        //所有元素出现的次数已经保存在temp中
        //遍历同级数组，输出结果
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                is[index++] = i;
            }
        }

    }
}
