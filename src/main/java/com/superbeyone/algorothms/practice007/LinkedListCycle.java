package com.superbeyone.algorothms.practice007;

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
