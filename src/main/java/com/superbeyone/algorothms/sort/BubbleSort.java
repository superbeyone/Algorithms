package com.superbeyone.algorothms.sort;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className BubbleSort
 * @description 冒泡排序
 * @date 2021-04-24 11:06
 **/

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1,5,3,10,7,6,9,0};

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    private static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j+1]<arr[j]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
