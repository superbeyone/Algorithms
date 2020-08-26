#### 反转字符串中的元音字符
Given s = "leetcode", return "leotcede".
使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。

为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。

时间复杂度为 O(N)：只需要遍历所有元素一次
空间复杂度 O(1)：只需要使用两个额外变量


```java
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
```

[LeetCode](https://leetcode.com/problems/reverse-vowels-of-a-string/description/)