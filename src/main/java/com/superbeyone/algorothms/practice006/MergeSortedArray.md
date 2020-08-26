MergeSortedArray
[LeetCode](https://leetcode-cn.com/problems/merge-sorted-array/)

合并两个有序数组

给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例:

```
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

```


```java
import java.util.Arrays;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className MergeSortedArray
 * @description Merge Sorted Array 归并两个有序数组
 * @date 2020-08-26 14:51
 **/

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);

    }

    //需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1, index2 = n - 1;
        int mergeIndex = m + n - 1;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[mergeIndex--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[mergeIndex--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[mergeIndex--] = nums1[index1--];
            } else {
                nums1[mergeIndex--] = nums2[index2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
    
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
        System.out.println(Arrays.toString(nums1));
    }

}
```