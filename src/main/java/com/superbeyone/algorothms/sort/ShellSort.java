package com.superbeyone.algorothms.sort;

import com.superbeyone.algorothms.utils.SortArrayUtil;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className ShellSort
 * @description 希尔排序
 * @date 2021-04-24 12:14
 **/

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = SortArrayUtil.getArray();
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int len = arr.length;
        int temp, grep = len / 2;

        while (grep > 0) {
            for (int i = grep; i < len; i++) {
                temp = arr[i];
                int preIndex = i - grep;
                while (preIndex >= 0 &&  arr[preIndex] > temp){
                    arr[preIndex + grep] = arr[preIndex];
                    preIndex -= grep;
                }

                arr[preIndex + grep] = temp;
                        
            }
            grep /= 2;
        }
    }
}
