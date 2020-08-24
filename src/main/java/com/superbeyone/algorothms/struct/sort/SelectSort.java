package com.superbeyone.algorothms.struct.sort;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className SelectSort
 * @description 选择排序
 * @date 2020-08-24 12:31
 **/

public class SelectSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        //选择排序
        selectSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    }

    /**
     * 选择排序 时间复杂度 O(n^2)
     *
     * @param arr 要排序的数组
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    //说明假定的最小值不是实际的最小值
                    //重置 min
                    min = arr[j];
                    //重置 minIndex
                    minIndex = j;
                }
            }

            //判断是否需要交换位置
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
