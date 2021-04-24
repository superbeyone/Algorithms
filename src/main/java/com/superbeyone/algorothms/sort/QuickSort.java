package com.superbeyone.algorothms.sort;

import com.superbeyone.algorothms.utils.SortArrayUtil;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className QuickSort
 * @description 快速排序
 * @date 2021-04-24 19:29
 **/

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = SortArrayUtil.getArray();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (arr.length < 1 || start < 0 || end >= arr.length || start > end) {
            return;
        }

        int smartIndex = partition(arr, start, end);
        if (smartIndex > start) {
            partition(arr, start, smartIndex - 1);
        }
        if (smartIndex < end) {
            partition(arr, smartIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;

        int smallIndex = start - 1;
        swap(arr, pivot, end);
        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(arr, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
