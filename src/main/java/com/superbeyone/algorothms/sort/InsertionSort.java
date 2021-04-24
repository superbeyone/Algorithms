package com.superbeyone.algorothms.sort;

import com.superbeyone.algorothms.utils.SortArrayUtil;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className InsertionSort
 * @description 插入排序
 * @date 2021-04-24 11:29
 **/

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = SortArrayUtil.getArray();

        System.out.println(Arrays.toString(array));
        
        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] arr) {

        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;

        }
    }
}
