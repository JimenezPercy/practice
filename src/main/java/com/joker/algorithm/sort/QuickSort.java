package com.joker.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author wangzhipeng01
 * @date 2020-08-01 12:39
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] is = {8, 3, 12, 18, -56, 23, 1, -1, 9};
        quickSortBoundary(is, 0, is.length - 1);

        for (int t : is) {
            System.out.println(t);
        }
    }

    /**
     * 边值法快速排序
     *
     * @param is
     * @param left
     * @param right
     */
    public static void quickSortBoundary(int[] is, int left, int right) {
        //比较指针
        if (left >= right) {
            return;
        }
        int index = left;
        //选取左端值为基准值，从左到右遍历
        for (int i = left + 1; i <= right; i++) {
            if (is[i] > is[left] && index == left) {
                //标注第一个大于基准值下标
                index = i;
            } else if (is[i] < is[left] && index != left) {
                //i指向的数据并非标注值的下一个，说明有连续且大于基准值的序列
                swap(is, i, index++);
                if (is[index] < is[left]) {
                    //说明i前面没有其他大于基准值的数据
                    index = left;
                }
            }
        }

        //待排序的值均小于基准值时，
        if (index == left) {
            swap(is, left, right);
        } else if (index > left + 1) {
            //index指向的是第一个大于基准值的数据
            swap(is, left, index - 1);
        }
        //递归排序左右子序列
        quickSortBoundary(is, left, index - 2);
        quickSortBoundary(is, index, right);
    }

    /**
     * 三数取中法快速排序
     *
     * @param is
     * @param left
     * @param right
     */
    public static void quickSortMidNumber(int[] is, int left, int right) {
        //比较指针
        if (left < right) {
            //获取基准值并将其放到待排序序列的末尾
            getPivot(is, left, right);
            int pivot = right - 1;
            //左指针
            int i = left;
            //右指针
            int j = right - 1;

            //从左到右遍历
            while (true) {
                //若左指针指向数据小于基准值，则无需变动，只把左指针后移一位
                while (is[++i] < is[pivot]) {
                }

                //若右指针指向数据大于基准值，则无需变动，只把右指针前移一位
                while (j > left && is[--j] > is[pivot]) {
                }

                if (j > i) {
                    swap(is, i, j);
                } else {
                    break;
                }
            }

            if (i < right) {
                //交换末尾值，此时左指针指向的数据不小于基准值针，且其左边数据均小于基准值
                swap(is, i, pivot);
            }

            //基准值新的下标为i
            //左边子列排序
            quickSortMidNumber(is, i + 1, right);
            //右子列排序
            quickSortMidNumber(is, left, i - 1);
        }
    }

    /**
     * 三数取中获取基准值
     */
    public static void getPivot(int[] is, int left, int right) {
        //找中间值
        int mid = (left + right) / 2;

        //左端、中间、右端的值两两比较，确保左<中<右
        //左边数据大于中间数据
        if (is[left] > is[mid]) {
            swap(is, left, mid);
        }
        //左边大于右边
        if (is[left] > is[right]) {
            swap(is, left, right);
        }
        //中间大于右边
        if (is[right] < is[mid]) {
            swap(is, right, mid);
        }

        swap(is, mid, right - 1);
    }

    private static void swap(int[] is, int a, int b) {
        int temp = is[a];
        is[a] = is[b];
        is[b] = temp;
    }
}
