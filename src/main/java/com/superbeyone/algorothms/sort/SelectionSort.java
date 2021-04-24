package com.superbeyone.algorothms.sort;

import com.superbeyone.algorothms.utils.SortArrayUtil;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className SelectionSort
 * @description 选择排序
 * @date 2021-04-24 11:13
 **/

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = SortArrayUtil.getArray();
        selectionSort(arr);        
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minInx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minInx]) {
                    minInx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minInx];
            arr[minInx] = temp;
        }
    }
}
