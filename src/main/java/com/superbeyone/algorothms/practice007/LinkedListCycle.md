
#### 判断链表是否存在环

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
示例 1：
```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```

使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className LinkedListCycle
 * @description Linked List Cycle 环形链表
 * @date 2020-08-27 14:17
 **/

public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        boolean result = hasCycle(listNode1);
        System.out.println(result);
    }


    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}
```

[LeetCode](https://leetcode.com/problems/linked-list-cycle)
 / [力扣](https://leetcode-cn.com/problems/linked-list-cycle)
 
 ---
 
 [***Mr.superbeyone***](https://github.com/superbeyone)
 
 ---