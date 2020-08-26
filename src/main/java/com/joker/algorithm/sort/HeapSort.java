package com.joker.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @Author: wzp
 * @Date: 2020/8/1 20:46
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] is = Base.is;
        sort(is);
        System.out.println(Arrays.toString(is));
    }

    public static void sort(int[] is) {
        //构建大顶堆
        //找到最后一个非叶子节点，开始调整结构
        for (int i = is.length / 2 - 1; i >= 0; i--) {
            //调整结构
            adjust(is, i, is.length);
        }
        //调整堆结构，交换堆顶和堆尾的元素
        for (int i = is.length - 1; i > 0; i--) {
            Base.swap(is, 0, i);
            //重新调整
            adjust(is, 0, i);
        }
    }

    //调整大顶堆
    public static void adjust(int[] is, int i, int length) {
        //取出当前元素,堆顶
        int temp = is[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //从i节点开始的左子节点开始
            if (k + 1 < length && is[k] < is[k + 1]) {
                //如果左节点小于右节点
                k++;
            }
            //比较子节点和父节点
            if (is[k] > temp) {
                //子节点大于父节点
                is[i] = is[k];
                //此处无需交换，只需将子节点上移
                i = k;
            } else {
                break;
            }
        }
        //将temp放入最终位置
        is[i]=temp;
    }
}
