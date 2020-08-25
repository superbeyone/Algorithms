package com.superbeyone.algorothms.struct.sort;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className ShellSort
 * @description 希尔排序
 * @date 2020-08-25 13:51
 **/

public class ShellSort {
    public static void main(String[] args) {
        int[] array = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        //希尔排序
        shellSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    /**
     * 希尔排序: 对有序序列在插入时采用交换法
     *
     * @param arr 待排序数组
     */
    private static void shellSort(int[] arr) {
        //遍历所有的步长
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //遍历所有的元素
            for (int j = i; j < arr.length; j++) {
                //遍历本数组中的所有元素
                for (int k = j - i; k >= 0; k -= i) {
                    //如果当前元素大于加上步长的那个元素
                    if (arr[k] > arr[k + i]) {
                        int temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序: 对有序序列在插入时采用移动法
     *
     * @param arr 待排序数组
     */
    private static void shellSort2(int[] arr) {

        //增量grep，并逐步缩小增量
        for (int grep = arr.length / 2; grep > 0; grep /= 2) {
            //遍历所有元素
            for (int i = grep; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - grep]) {
                    while (j - grep >= 0 && temp < arr[j - grep]) {
                        //移动法
                        arr[j] = arr[j - grep];
                        j -= grep;
                    }
                    arr[j] = temp;
                }

            }
        }
    }
}
