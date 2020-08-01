package com.joker.algorithm.sort;

/**
 * 选择排序
 *
 * @Author: wzp
 * @Date: 2020/7/31 21:52
 */
public class Selection {
    public static void main(String[] args) {
        int[] is = {8, 3, 12, 18, -56, 23, 1, -1, 9};

        //循环轮数，n-1
        for(int i=0;i<is.length-1;i++){
            int minIndex=i;
            //每轮找最小值
            for(int j=i+1;j<is.length;j++){
                if(is[j]<is[minIndex]){
                    minIndex=j;
                }
            }
            //每一轮最后交换一次
            int temp=is[i];
            is[i]=is[minIndex];
            is[minIndex]=temp;
        }

        for(int t:is){
            System.out.println(t);
        }
    }
}
