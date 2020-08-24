package com.superbeyone.algorothms.struct.sort;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className BubbleSort
 * @description 冒泡排序
 * @date 2020-07-24 14:01
 **/

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = new int[]{3, 9, -1, 10, 20, 6};
        long start = System.currentTimeMillis();
        //冒泡排序
        bubbleSort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + " 毫秒");

    }

    /**
     * 冒泡排序 时间复杂度 O(n^2)
     *
     * @param array 数组
     */
    private static void bubbleSort(int[] array) {
        //临时变量
        int tmp = 0;
        //标识位，标志是否交换过
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                //如果前面的数比后一个数大，交换
                if (array[j] > array[j + 1]) {
                    flag = true;
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }

            if (!flag) {
                //在一趟排序中如果没有交换过
                break;
            } else {
                //重置标志位
                flag = false;
            }
        }
    }

}
