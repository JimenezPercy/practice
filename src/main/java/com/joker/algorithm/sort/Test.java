package com.joker.algorithm.sort;

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
        long startTime = new Date().getTime();
//        bubble();//冒泡
//        selection();//选择
//        insertion();//插入
        shells(4);//希尔
        long endTime = new Date().getTime();
        System.out.println(Arrays.toString(data));
        System.out.println("执行时间：" + (endTime - startTime) + "ms");
        check();

//        test();
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
                System.out.println("测试失败");
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
            data = Base.data(10000);
            long startTime = new Date().getTime();
//            bubble();
//            selection();
//            insertion();
            shells(4);
            long endTime = new Date().getTime();
            System.out.println("执行时间：" + (endTime - startTime) + "ms");

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
