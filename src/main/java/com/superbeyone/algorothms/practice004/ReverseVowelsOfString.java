package com.superbeyone.algorothms.practice004;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className ReverseVowelsOfString
 * @description 反转字符串中的元音字符
 * @date 2020-08-26 11:48
 **/

public class ReverseVowelsOfString {


    private final static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        String s = "leetcode";
        String result = reverseVowelsOfString(s);
        System.out.println(result);
    }

    private static String reverseVowelsOfString(String s) {
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
