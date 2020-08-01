package com.joker.algorithm.sort;

/**
 * 归并排序
 *
 * @Author: wzp
 * @Date: 2020/8/1 8:26
 */
public class Merge {
    public static void main(String[] args) {
        int[] is = {8, 3, 12, 18, -56, 23, 1, -1, 9};

        sort(is);

        for (int t : is) {
            System.out.println(t);
        }
    }

    //二叉树
    public static void sort(int[] is) {
        //在排序前，建好一个长度等于原数组长度的临时数组
        //避免在递归中频繁开辟数组
        int[] temp = new int[is.length];

        sort(is, 0, is.length - 1, temp);
    }

    public static void sort(int[] is, int left, int right, int[] temp) {
        //不必强求元素个数的奇偶
        if (left < right) {
            //找中间的位置
            int mid = (left + right) / 2;

            //递归
            //左
            sort(is, left, mid, temp);
            //右
            sort(is, mid + 1, right, temp);

            //并
            merge(is, left, mid, right, temp);
        }

    }

    public static void merge(int[] is, int left, int mid, int right, int[] temp) {
        //定义两个指针
        int i = left;
        int j = mid + 1;
        //临时数组指针
        int index = 0;

        while (i <= mid && j <= right) {
            //遍历边界
            if (is[i] < is[j]) {
                //左边小于右边，将左边当前指针指向的值放入临时数组
                temp[index++] = is[i++];
            } else {
                //左边不小于右边，将右边当前指针指向的值放入临时数组
                temp[index++] = is[j++];
            }
        }
        //至少有一边已空，把未空的依次放入临时数组
        //右空
        while (i <= mid) {
            temp[index++] = is[i++];
        }
        //左空
        while (j <= right) {
            temp[index++] = is[j++];
        }
        //游标置空
        index = 0;

        //把临时数组拷贝到原数组中
        while (left <= right) {
            is[left++] = temp[index++];
        }
    }
}
