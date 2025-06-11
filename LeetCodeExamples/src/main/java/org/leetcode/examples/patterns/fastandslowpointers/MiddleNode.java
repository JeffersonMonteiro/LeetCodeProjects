package org.leetcode.examples.patterns.fastandslowpointers;

import org.leetcode.examples.linkedlist.model.Node;

public class MiddleNode {


    //USING TECHNIQUE - BEST PERFORMANCE
    static Node middleNode(Node head){
        Node slow = head;
        Node fast = head;

        //Mode slow by 1 and fast by 2 steps
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // No Cycle

    }

    //OLD VERSION - POOR PERFORMANCE
    static Node oldMiddleNode(Node head){
        int count = 0;
        Node current = head;

        //First pass to count the number of nodes
        while(current != null){
            count++;
            current = current.next;
        }

        //Second pass to find the middle node
        current = head;
        for(int i= 0; i < count/2; i++){
            current = current.next;
        }

        return current; // This will be the middle node


    }

}
