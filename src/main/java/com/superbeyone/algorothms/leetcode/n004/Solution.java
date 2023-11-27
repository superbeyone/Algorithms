package com.superbeyone.algorothms.leetcode.n004;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution
 * @description
 * @date 2023-10-12 16:00
 **/

public class Solution {

    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = 0, n2 = 0;
        int total = nums1.length + nums2.length;
        int[] res = new int[total];

        int index = 0;
        int v1,v2;
        while (index < total) {
            
            if(n1 >= nums1.length){
                
                res[index++] = nums2[n2++];
                continue;
            }
            if(n2 >= nums2.length){
                res[index++] = nums1[n1++];
                continue;
            }
            //都有值
            v1 = nums1[n1];
            v2 = nums2[n2];
            if(v1 < v2){
                res[index++] = v1;
                n1++;
            }else{
                res[index++] = v2;
                n2++;
            }
            
        }

        if (total % 2 == 0) {
            return (double) (res[total / 2 - 1] + res[total / 2]) / 2;
        }
        return res[total / 2 ];
    }
}
