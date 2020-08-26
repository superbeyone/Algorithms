package com.superbeyone.algorothms.practice006;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className MergeSortedArray
 * @description Merge Sorted Array 归并两个有序数组
 * @date 2020-08-26 14:51
 **/

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);

    }

    //需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1, index2 = n - 1;
        int mergeIndex = m + n - 1;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[mergeIndex--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[mergeIndex--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[mergeIndex--] = nums1[index1--];
            } else {
                nums1[mergeIndex--] = nums2[index2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
