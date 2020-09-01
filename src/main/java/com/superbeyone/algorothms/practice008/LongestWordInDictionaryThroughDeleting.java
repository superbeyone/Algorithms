package com.superbeyone.algorothms.practice008;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className LongestWordInDictionaryThroughDeleting
 * @description 最长子序列
 * @date 2020-09-01 16:04
 **/

public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {
        String s = "abpcplea";
        String[] d = new String[]{"ale", "apple", "monkey", "plea"};
        System.out.println(findLongestWord(s, Arrays.asList(d)));
    }

    public static String findLongestWord(String s, List<String> d) {

        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubStr(s, target)) {
                longestWord = target;
            }
        }

        return longestWord;
    }

    private static boolean isSubStr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}