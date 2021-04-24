package com.superbeyone.algorothms.practice010;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className TheNPowOfA
 * @description n次幂
 * @date 2021-04-24 20:47
 **/

public class TheNPowOfA {

    public static void main(String[] args) {
        int a = 2;
        int n = 10;
        int res = pow(a, n);
        System.out.println(res);
    }

    private static int pow(int a, int n) {
        if(n==0){
            return 1;
        }
        int res = a;
        int ex = 1;

        while ((ex << 1) <= n) {
            res *= res;
            ex <<= 1;
        }

        return res * pow(a, n - ex);
    }
}
