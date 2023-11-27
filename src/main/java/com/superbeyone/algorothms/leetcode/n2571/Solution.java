package com.superbeyone.algorothms.leetcode.n2571;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution
 * @description
 * @date 2023-10-12 11:42
 **/

class Solution {

    public static void main(String[] args) {
        int n = 404;
        System.out.println(new Solution().minOperations(n));
    }
    public int minOperations(int n) {
        //该题意为找到给定值的最近的符合2的幂数字
        if(n <= 0){
            return 0;
        }
        


        int result = getCount(n);

        System.out.println("-----------------");
        System.out.println(result);
        System.out.println("----------------------");

        return result;

    }

    public int getCount(int n){
        int m = getNearNum(n);

        int num = Math.abs(m-n);
        int count = 0;

        while(num > 0){
            count++;
            int a =2;
            while(num > a *2){
                a *= 2;
            }
            if(num == a*2){
                break;
            }
            if(Math.abs(num - a*2) < Math.abs(num - a)){
                num += Math.abs(num - a*2);
            }else{
                num -= a;
            }
            
            
        }

        return count+1;
    }

    public int getNearNum(int n){
        int m = n;
        int count = m%2==0 ? 0 :1;


        while(m > 1){
            m = (int)(m - Math.pow(2,count));
            count++;
        }


        int max = (int)Math.pow(2,count);
        
        return Math.abs(max - n) < Math.abs(max/2 - n) ? max:max/2;

    }
}