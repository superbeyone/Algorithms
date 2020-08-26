package com.superbeyone.algorothms.struct.sort;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className QuickSort
 * @description 快速排序
 * @date 2020-08-26 13:05
 **/

public class QuickSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        //快速排序
        quickSort(0, array.length - 1, array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    private static void quickSort(int left, int right, int[] arr) {

        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
            if (l == r) {
                l++;
                r--;
            }
            if (left < r) {
                quickSort(left, r, arr);
            }
            if (right > l) {
                quickSort(l, right, arr);
            }
        }

    }
}