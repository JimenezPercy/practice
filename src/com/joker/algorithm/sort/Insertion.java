package com.joker.algorithm.sort;

/**
 * 插入排序
 *
 * @Author: wzp
 * @Date: 2020/7/31 22:33
 */
public class Insertion {
    public static void main(String[] args) {
        int[] is = {8, 3, 12, 18, -56, 23, 1, -1, 9};

        //将第一个值看作有序序列
        for(int i=1;i<is.length;i++){
            //从无序序列，即第二个值至最后，每次挑选一个值，倒序与前面值比较，找到一个前面比它小的值或前面没有值的位置
            for(int j=i;j>0&&is[j]<is[j-1];j--){
                int temp=is[j];
                is[j]=is[j-1];
                is[j-1]=temp;
            }
        }

        for(int t:is){
            System.out.println(t);
        }
    }
}
