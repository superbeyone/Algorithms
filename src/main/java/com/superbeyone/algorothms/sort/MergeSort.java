package com.superbeyone.algorothms.sort;

import com.superbeyone.algorothms.utils.SortArrayUtil;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className MergeSort
 * @description 归并排序
 * @date 2021-04-24 12:39
 **/

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = SortArrayUtil.getArray();
        int[] result = mergeSort(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return merge(mergeSort(left), mergeSort(right));

    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int index = 0, l = 0, r = 0; index < result.length; index++) {
            if (l >= left.length) {
                result[index] = right[r++];
            } else if (r >= right.length) {
                result[index] = left[l++];
            } else if (left[l] > right[r]) {
                result[index] = right[r++];
            } else {
                result[index] = left[l++];
            }
        }

        return result;
    }
}
