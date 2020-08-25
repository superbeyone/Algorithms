
题目描述：判断一个非负整数是否为两个整数的平方和。

可以看成是在元素为 0~target 的有序数组中查找两个数，使得这两个数的平方和为 target，如果能找到，则返回 true，表示 target 是两个整数的平方和。

本题和 167. Two Sum II - Input array is sorted 类似，只有一个明显区别：一个是和为 target，一个是平方和为 target。本题同样可以使用双指针得到两个数，使其平方和为 target。

本题的关键是右指针的初始化，实现剪枝，从而降低时间复杂度。设右指针为 x，左指针固定为 0，为了使 02 + x2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。

因为最多只需要遍历一次 0~sqrt(target)，所以时间复杂度为 O(sqrt(target))。又因为只使用了两个额外的变量，因此空间复杂度为 O(1)。

```java
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
```