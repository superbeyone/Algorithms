package com.superbeyone.algorothms.test;

import java.util.ArrayList;

/**
 * @author Mr.superbeyone
 * @project algorithms
 * @className Test
 * @description
 * @date 2023-03-20 11:49
 **/

public class Test {
    
    

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.remove(1);
    }
    
    private static Node solution(Node node){
        if(node == null){
            return null;
        }

        Node preNode = null;
        Node curNode = node;
        
        while (curNode != null){
           Node next = curNode.next;
           curNode.next = preNode;
           preNode= curNode;
           curNode = next;            
        }
        return node;
        
    }
}

class Node{
    Node next;
    int val;
    
}
