package com.superbeyone.algorothms.struct.sort;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className MergeSort
 * @description 归并排序
 * @date 2020-08-27 14:43
 **/

public class MergeSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        //归并排序
        mergeSort1(array, 0, array.length - 1, new int[array.length]);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    /**
     * 递归方式
     *
     * @param arr
     */
    private static void mergeSort1(int[] arr, int left, int right, int[] temp) {

        //默认 left < right
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort1(arr, left, mid, temp);

            mergeSort1(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        //将左边剩余元素填充到 temp[] 中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        //将右边剩余元素填充到 temp[] 中
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
