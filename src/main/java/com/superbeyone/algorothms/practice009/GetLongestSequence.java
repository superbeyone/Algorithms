package com.superbeyone.algorothms.practice009;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className GetLongestSequence
 * @description 获取最长子序列
 * @date 2021-04-24 20:15
 **/

public class GetLongestSequence {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 2, 7, 3, 4, 5, 8, 0};

        int[] result = getLongestSequence(arr);

        System.out.println(Arrays.toString(result));
    }

    private static int[] getLongestSequence(int[] arr) {
        int start = 0;
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && arr[i] <= arr[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return Arrays.copyOfRange(arr, start, start + ans);
    }
}
