package com.superbeyone.algorothms.leetcode.n0003;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Soultion
 * @description https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @date 2023-06-05 10:54
 **/

public class Solution {

    public static void main(String[] args) {

        String s = "abcabacbb";
        int result = new Solution().getLength(s);
        System.out.println(result);
    }
    
    
    public int getLength(String s){
        
        int ans =0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int endOps = -1; //结束游标
        for(int i=0; i < n; ++i){
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            
            while (endOps +1 < n && !set.contains(s.charAt(endOps+1))){
                set.add(s.charAt(endOps+1));
                ++endOps;
            }
            
            ans = Math.max(ans,endOps - i +1);
        }
        
        return ans;
    }

    public  int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();

        if (chars.length == 1) {
            return 1;
        }
        int maxLength = 0;
        Set<Character> set = new HashSet<Character>();

        int left = 0;
        int right = -1;
        for (int i = 0; i < chars.length; i++) {
            while (chars[left] != chars[right]) {
                right++;
            }

        }
        int[] res = new int[10];
        return maxLength;
    }
}
