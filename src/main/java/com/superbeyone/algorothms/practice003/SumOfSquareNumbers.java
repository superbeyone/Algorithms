package com.superbeyone.algorothms.practice003;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className SumOfSquareNumbers
 * @description 两数平方和
 * @date 2020-08-25 12:12
 **/

public class SumOfSquareNumbers {


    public static void main(String[] args) {

        int num = 5;
        boolean result = judgeSquareSum(num);
        System.out.println(result);
    }

    public static boolean judgeSquareSum(int c) {

        int i = 0, j = (int) Math.sqrt(c);

        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
