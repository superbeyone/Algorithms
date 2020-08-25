package com.superbeyone.algorothms.struct.sort;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className InsertSort
 * @description 插入排序
 * @date 2020-08-25 12:45
 **/

public class InsertSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.getArray();
        long start = System.currentTimeMillis();
        //选择排序
        insertSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");

    }

    /**
     * 插入排序
     *
     * @param arr 待排序数组
     */
    private static void insertSort(int[] arr) {

        //当需要插入的数是较小的数时，后移的次数明显增多，对效率有影响.
        for (int i = 0; i < arr.length; i++) {
            int insertVal = arr[i];
            //有序表的最后这个元素的下标
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环，说明插入位置找到了
            arr[insertIndex + 1] = insertVal;
        }
    }
}
