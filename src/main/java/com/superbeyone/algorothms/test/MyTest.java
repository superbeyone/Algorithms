package com.superbeyone.algorothms.test;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className MyTest
 * @description
 * @date 2023-03-20 17:43
 **/

public class MyTest {

    public static void main(String[] args) {

        ListNode l111 = new ListNode(8, null);
        ListNode l11 = new ListNode(7, l111);

        ListNode l1 = new ListNode(6, l11);


        ListNode l2 = new ListNode(9, null);
        ListNode result = getResultNode(l1, l2);
        System.out.println(result);

    }

    private static ListNode getResultNode(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        if (l1 == null || l2 == null) {
            return result;
        }

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        while (l1 != null) {
            int val = l1.val;
            l1 = l1.next;
            s1.append(val);
        }
        while (l2 != null) {
            int val = l2.val;
            l2 = l2.next;
            s2.append(val);
        }

        char[] s1Arr = s1.reverse().toString().toCharArray();
        char[] s2Arr = s2.reverse().toString().toCharArray();

        int s1Length = s1Arr.length;
        int s2Length = s2Arr.length;
        int index = 0;

        StringBuilder resultBuilder = new StringBuilder();
        int needPlus = 0;
        while (index < Math.min(s1Length, s2Length)) {
            int resultTemp = s1Arr[index] - 48 + s2Arr[index] - 48 + needPlus;
            if (resultTemp > 10) {

                needPlus = 1;
                resultBuilder.append(resultTemp % 10);

            } else {
                needPlus = 0;
                resultBuilder.append(resultTemp);
            }
            index++;
        }

        char[] arr = s1Length > s2Length ? s1Arr : s2Arr;
        for (int i = index; i < arr.length; i++) {
            int resultTemp = arr[index] - 48 + needPlus;

            if (resultTemp > 10) {

                needPlus = 1;
                resultBuilder.append(resultTemp % 10);

            } else {
                needPlus = 0;
                resultBuilder.append(resultTemp);
            }
            index++;
        }


        char[] resultArr = resultBuilder.reverse().toString().toCharArray();

        ListNode preNode = null;
        if (resultArr.length > 0) {
            preNode = new ListNode(resultArr[0] - 48, null);
        }
        result = preNode;
        for (int i = 1; i < resultArr.length; i++) {
            ListNode tempNode = new ListNode();
            tempNode.val = resultArr[i] - 48;
            preNode.next = tempNode;
            preNode = tempNode;
        }

        return result;
    }

}

class ListNode {
    ListNode next;
    int val;

    public ListNode() {

    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
