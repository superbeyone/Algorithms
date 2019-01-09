package com.superbeyone.algorothms.practice003;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution
 * @description sum-of-square-numbers
 * @create 2019-01-09 09:41
 **/

/**
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powerSum = i * i + j * j;
            if (powerSum == c) {
                return true;
            } else if (powerSum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
