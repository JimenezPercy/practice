package com.joker.algorithm.sort;

/**
 * 希尔排序
 *
 * @Author: wzp
 * @Date: 2020/7/31 23:28
 */
public class ShellsSort {

    public static void main(String[] args) {
        int[] is = {8, 3, 12, 18, -56, 23, 1, -1, 9};

        //准备增量序列
        int g = 1;
        do {
            g = g * 2;
        } while (g < is.length);

//        while (g>0){
//            System.out.println(g/=3);
//        }
        //循环跨度
        while (g > 0) {
            //无需每组单独排序，从第一组的第二个元素向后依次循环即可
            for (int i = g; i < is.length; i++) {
                //每轮循环都是插入排序，从组内第二个元素倒序比较
//                for (int j = i; j >=g && is[j] < is[j - g]; j -= g) {
//                    int temp = is[j];
//                    is[j] = is[j - g];
//                    is[j - g] = temp;
//                }

                int temp = is[i];
                int j = i - g;
                while (j >= 0 && is[j] > temp) {
                    is[j + g] = is[j];
                    j -= g;
                }
                is[j + g] = temp;
            }

            //增量序列从大到小比较
            g /= 2;
        }

        for (int t : is) {
            System.out.println(t);
        }
    }
}
