package com.superbeyone.algorothms.protices011;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution2
 * @description
 * @date 2023-03-07 15:01
 **/

public class Solution2 {


    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3,5,5,3,1,1,1,1};
        int[] result = getResult(arr);
        System.out.println(result);
        
    }
    
    private static int[] getResult(int[] array){
        
        if(array == null) {
            return null;
        }
        int n = array.length;
        int s0 =0,s1 =array.length -1;

        int max = array[0];
        
        int minIndex = 0;
        int maxIndex = 0;
        for(int i =0; i< n;  i++){
            
            //末尾值大
            if(array[s0] < array[s1]){
                
                if(array[s0 +1] > array[s0]){
                    //后者比前者大
                    
                    max = Math.max(max, array[s0+1]);
                    minIndex = s0+1;
                }else{
                    //该数是最大的
                    max = Math.max(max, array[s0]);
                    
                }
                s0++;
                
            }else{
                if(array[s1 - 1] > array[s1]){
                    //前者比后者大
                    
                    max = Math.max(max, array[s1-1]);
                    maxIndex = s1-1;
                }else{
                    max = Math.max(max, array[s1]);
                    
                }
                s1--;
            }
            
        }
     
        return new int[]{max,maxIndex-minIndex +1};
    }
}
