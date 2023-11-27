package com.superbeyone.algorothms.protices011;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Solution
 * @description
 * @date 2023-03-07 14:18
 **/

public class Solution {


    public static void main(String[] args) {
        Node[] nodes = initNode();
        Node[] results = getNotLinkedList(nodes);
        System.out.println(results);
    }
    public static Node[] getNotLinkedList(Node[] roots) {

        if (roots == null) {
            return null;
        }

        int N = roots.length;
        Set<Integer> reSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            Node root = roots[i];
            Node preNode = root;
            while (root != null) {

                preNode = root;
                root = root.next;
                if(root == null){
                    break;
                }
                int index = root.index;
                
                if(preNode.index == root.index){
                    break;
                }
                reSet.add(index);

            }
        }

        for (int i = 0; i < N; i++) {
            if (reSet.contains(i)) {
                roots[i] = null;
            }
        }
        return roots;

    }

    private static Node[] initNode(){

        Node[] array = new Node[5];

        Node node0 = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        node0.index=0;
        node0.next=node1;
        array[0]= node0;

        node1.index=1;
        node1.next=node1;
        array[1]= node1;

        node2.index=(2);
        node2.next=node2;
        array[2]= node2;

        node3.index=(3);
        node3.next=node1;
        array[3]= node3;

        node4.index=4;
        node4.next=node3;
        array[4]= node4;

        return array;
    }
}


class Node{
    public int index;
    
    public Node next;
}