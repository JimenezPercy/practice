package com.joker.algorithm.sort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 桶排序
 *
 * @Author: wzp
 * @Date: 2020/8/2 9:19
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] is = Base.is;

        sort(is);
        System.out.println(Arrays.toString(is));
    }

    public static void sort(int[] is) {
        //找到最大值和最小值
        int max = is[0];
        int min = is[0];

        for (int i : is) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        //桶个数
        int num = 5;

        //求每个桶的范围
        double space = (max - min + 1) / num;

        //创建空桶
        LinkedList<Integer>[] list = new LinkedList[num];

        //把原数列当中的数据，均匀的分布到每个桶里
        for (int i = 0; i < is.length; i++) {
            //找到当前值要放入的桶的序列
            int index = (int) Math.floor((is[i] - min) / space);
            //往桶里放入元素
            if (list[index] == null) {
                list[index] = new LinkedList<Integer>();
                list[index].add(is[i]);
            } else {
                //如果不为空，对桶元素进行排序
                //比最小的小，放到前面
                //比最大的大，放到后面
                LinkedList<Integer> l = list[index];
                int temp = is[i];
                if (temp < l.getFirst()) {
                    //比第一个小，放到前面
                    l.addFirst(temp);
                } else if (temp > l.getLast()) {
                    //比最后一个大，放到后面
                    l.addLast(temp);
                } else {
                    //两者之间
                    int k = list[index].size() - 1;
                    while (k >= 0 && list[index].get(k) > is[i]) {
                        if (k + 1 > list[index].size() - 1) {
                            list[index].add(list[index].get(k));
                        } else {
                            list[index].set(k + 1, list[index].get(k));
                        }
                        k--;
                    }

                    if (k + 1 > list[index].size() - 1) {
                        list[index].add(is[i]);
                    } else {
                        list[index].set(k + 1, is[i]);
                    }
                }
                //往桶里面添加元素的时候，加完是有序的
            }


        }
        //合并桶
        int index = 0;
        for (LinkedList<Integer> l : list) {
            if (l != null) {
                for (int i : l) {
                    is[index++] = i;
                }
            }
        }

    }
}
