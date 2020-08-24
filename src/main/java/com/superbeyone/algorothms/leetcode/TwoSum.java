package com.superbeyone.algorothms.leetcode;

import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className TwoSum
 * @description 有序数组的 Two Sum
 * @date 2020-08-24 13:18
 **/

public class TwoSum {


    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     *
     * @param numbers 有序数组
     * @param target  目标值
     * @return 结果
     */
    public static int[] twoSum(int[] numbers, int target) {

        if (numbers == null) {
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

}
