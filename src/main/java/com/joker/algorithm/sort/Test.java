package com.joker.algorithm.sort;

import com.joker.reflect.practice.Person;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: wzp
 * @Date: 2020/12/11 22:05
 */
public class Test {
    private static int[] data;

    public static void main(String[] args) {
        data = Base.data(10000);
        System.out.println(Arrays.toString(data));
        long startTime = new Date().getTime();
//        bubble();//冒泡
//        selection();//选择
//        insertion();//插入
//        shells(4);//希尔
//        merge();//归并
//        quick();//快速
        heap();//堆
        long endTime = new Date().getTime();
        System.out.println(Arrays.toString(data));
        System.out.println("执行时间：" + (endTime - startTime) + "ms");
        check();

//        test();
    }

    /**
     * 堆排序
     * 数据规模10000，执行时间：1ms 2ms 1ms 1ms 1ms 0ms 1ms 1ms 1ms 1ms
     * 数据规模100000，执行时间：11ms 10ms 10ms 9ms 8ms 8ms 9ms 8ms 8ms 8ms
     * 数据规模1000000，执行时间：121ms 114ms 108ms 110ms 122ms 121ms 127ms 110ms 114ms 112ms
     */
    private static void heap() {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            adjust(i, data.length);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            swap(0, i);
            adjust(0, i);
        }
    }

    /**
     * 堆排序，调整
     */
    private static void adjust(int k, int length) {
        //堆顶
        int temp = data[k];

        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            if (i < length - 1 && data[i] < data[i + 1]) {
                i++;
            }
            if (data[i] > temp) {
                data[k] = data[i];
                k = i;
            } else {
                break;
            }

        }
        data[k] = temp;
    }

    /**
     * 快速排序
     * 数据规模10000，执行时间：1ms 1ms 1ms 1ms 1ms 1ms 1ms 1ms 1ms 1ms
     * 数据规模100000，执行时间：15ms 8ms 6ms 7ms 7ms 7ms 6ms 7ms 7ms 7ms
     * 数据规模1000000，执行时间：107ms 81ms 80ms 79ms 80ms 82ms 80ms 81ms 83ms 79ms
     */
    private static void quick() {
        quickSort(0, data.length - 1);
    }

    private static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        //基准值
        pivot(left, right);

        int pivot = right - 1;
        int i = left + 1;
        int j = pivot;

        if (i >= j) {
            return;
        }

        while (i < j) {
            while (data[i] < data[pivot] && i < pivot) {
                i++;
            }
            while (data[j] >= data[pivot] && j > left) {
                j--;
            }
            if (i < j) {
                swap(i, j);
            }
        }
        //交换左指针指向的值和基准值，此时基准值在最终位置
        swap(i, pivot);
        pivot = i;
        quickSort(left, pivot - 1);
        quickSort(pivot + 1, right);
    }

    /**
     * 获取基准值，
     */
    private static void pivot(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        if (data[left] > data[mid]) {
            swap(left, mid);
        }

        if (data[mid] > data[right]) {
            swap(mid, right);
        }

        if (data[left] > data[mid]) {
            swap(left, mid);
        }
        //将基准值放在待排序列末尾
        swap(mid, right - 1);
    }

    /**
     * 归并排序
     * 数据规模10000，执行时间：6ms 3ms 2ms 3ms 2ms 4ms 2ms 10ms 3ms 2ms
     * 数据规模100000，执行时间：29ms 11ms 10ms 13ms 9ms 10ms 10ms 10ms 9ms 10ms
     * 数据规模1000000，执行时间：123ms 106ms 107ms 108ms 113ms 112ms 116ms 106ms 106ms 105ms
     */
    private static void merge() {
        int[] temp = new int[data.length];

        mergeSeparateSort(0, data.length - 1, temp);
    }

    /**
     * 归并排序，递归拆分排序
     */
    private static void mergeSeparateSort(int left, int right, int[] temp) {
        //分
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSeparateSort(left, mid, temp);
        mergeSeparateSort(mid + 1, right, temp);

        //合
        int s = left;
        int e = mid + 1;
        int index = 0;
        while (s <= mid && e <= right) {
            if (data[s] <= data[e]) {
                temp[index++] = data[s++];
            } else {
                temp[index++] = data[e++];
            }
        }

        //一边全部添加到temp中，将另一边剩下所有全部放入temp
        if (s > mid) {
            while (e <= right) {
                temp[index++] = data[e++];
            }
        } else {
            while (s <= mid) {
                temp[index++] = data[s++];
            }
        }

        //放入原数组
        index = 0;
        for (int i = left; i <= right; i++) {
            data[i] = temp[index++];
        }

    }


    /**
     * 希尔排序
     * 数据规模10000，跨度4，执行时间：131ms 129ms 55ms 54ms 52ms 53ms 56ms 55ms 57ms 64ms
     * 数据规模100000，跨度4，执行时间：11389ms 11840ms 5472ms 5659ms 5487ms 5651ms 5582ms 5500ms 5624ms 5549ms
     */
    private static void shells(int span) {
        if (span <= 1) {
            System.out.println("滚蛋");
            return;
        }
        //跨度
        int g = 1;
        do {
            g = g * span;
        } while (g < data.length);

        for (g = g / span; g >= 1; g = g / span) {
            for (int i = g; i < data.length; i++) {
                int point = i;
                for (int j = i - g; j >= 0; j -= g) {
                    if (data[point] < data[j]) {
                        swap(point, j);
                        point = j;
                    }
                }
            }
        }
    }

    /**
     * 插入排序
     * 数据规模10000，执行时间：45ms 50ms 46ms 51ms 44ms 49ms 47ms 40ms 42ms 41ms
     * 数据规模100000，执行时间：4012ms 3765ms 3918ms 4101ms 4209ms 4140ms 4185ms 4160ms 4152ms 4143ms
     */
    private static void insertion() {
        for (int i = 1; i < data.length; i++) {
            int point = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[point] < data[j]) {
                    swap(point, j);
                    point = j;
                }
            }
        }
    }

    /**
     * 选择排序
     * 数据规模10000，执行时间：57ms 72ms 59ms 63ms 75ms 69ms 74ms 92ms 65ms 71ms
     * 数据规模100000，执行时间：5859ms 5943ms 2794ms 2660ms 2794ms 2643ms 2629ms 2675ms 2781ms 2855ms
     */
    private static void selection() {
        for (int i = 0; i < data.length - 1; i++) {
            int point = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[point]) {
                    point = j;
                }
            }
            if (i != point) {
                swap(i, point);
            }
        }
    }

    /**
     * 冒泡
     * 数据规模10000，执行时间：133ms 146ms 113ms 100ms 99ms 105ms 103ms 118ms 105ms 111ms
     * 数据规模100000，执行时间：15593ms 17753ms 13704ms 13725ms 13529ms 13017ms 12289ms 12295ms 12666ms 13403ms
     */
    private static void bubble() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    /**
     * 检查
     */
    private static void check() {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                System.out.println("测试失败====================================================================");
                return;
            }
        }
        System.out.println("检查通过");
    }

    /**
     * 测试多次
     */
    private static void test() {
        for (int i = 0; i < 10; i++) {
            data = Base.data(1000000);
            long startTime = new Date().getTime();
//            bubble();
//            selection();
//            insertion();
//            shells(4);
//            merge();
//            quick();
//            heap();
            long endTime = new Date().getTime();
            System.out.println("执行时间：" + (endTime - startTime) + "ms");
            check();

        }
    }

    /**
     * 交换
     *
     * @param i
     * @param j
     */
    private static void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
