package com.superbeyone.algorothms.practice004;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution
 * @description Reverse Vowels of a String
 * @create 2019-01-09 09:48
 **/

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 'hello'
 * Output: 'holle'
 * Example 2:
 * <p>
 * Input: 'leetcode'
 * Output: 'leotcede'
 * Note:
 * The vowels does not include the letter 'y'.
 */
public class Solution {

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;

        char[] chars = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                chars[i++] = ci;
            } else if (!vowels.contains(cj)) {
                chars[j--] = cj;
            } else {
                chars[i++] = cj;
                chars[j--] = ci;
            }
        }
        return new String(chars);
    }
}
