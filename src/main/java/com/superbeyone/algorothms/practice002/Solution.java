package com.superbeyone.algorothms.practice002;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution
 * @description 在有序数组中找出两个数，使它们的和为 target
 * @create 2019-01-09 09:29
 **/

/**
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {


    /**
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * <p>
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
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
