## Algorithms Solving
### 1. minimum-depth-of-binary-tree
```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
    /**
     * 深度优先遍历（DFS）
     * 如果当前节点为空，则最小深度为0
     * 效率低
     *
     * @param root
     * @return
     */
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = run(root.left);
        int r = run(root.right);
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        return Math.min(l, r) + 1;
    }

    /**
     * 广度优先遍历（BFS）
     * 找到第一个叶子结点就停止遍历
     * 效率高
     *
     * @param root
     * @return
     */
    public int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> layerList = new LinkedList<>();
        queue.addFirst(root);
        int start = 0;
        int end = 1;
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.removeLast();
            start++;
            layerList.addFirst(temp);
            if (temp.left == null && temp.right == null) {
                return level;
            }
            if (temp.left != null) {
                queue.addFirst(temp.left);
            }
            if (temp.right != null) {
                queue.addFirst(temp.right);
            }

            if (start == end) {
                level++;
                start = 0;
                end = queue.size();
                layerList = new LinkedList<>();
            }
        }
        return level;
    }

}
```
### 2. two-sum-ii-input-array-is-sorted
```java
/**
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {


    /**
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * <p>
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }

        }
        return null;
    }
}
```
### 3. sum-of-square-numbers
```java
/**
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powerSum = i * i + j * j;
            if (powerSum == c) {
                return true;
            } else if (powerSum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
```
### 4. Reverse Vowels of a String
```java
/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 'hello'
 * Output: 'holle'
 * Example 2:
 * <p>
 * Input: 'leetcode'
 * Output: 'leotcede'
 * Note:
 * The vowels does not include the letter 'y'.
 */
public class Solution {

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
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
### 5. Valid Palindrome II
```java
/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class Solution {

    public  boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
```
### 6. Merge Sorted Array
```java
public class Solution {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
```