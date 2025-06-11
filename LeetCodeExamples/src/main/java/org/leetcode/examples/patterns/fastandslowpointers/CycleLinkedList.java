package org.leetcode.examples.patterns.fastandslowpointers;

import org.leetcode.examples.linkedlist.model.Node;

import java.util.HashSet;

public class CycleLinkedList {

    //USING TECHNIQUE - BEST PERFORMANCE
    static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == fast){
            return true; //Cycle Detected
        }

        return false; // No Cycle

    }

    //OLD VERSION - POOR PERFORMANCE
    static boolean oldHasCycle(Node head){
        HashSet<Node> visited = new HashSet<>();
        Node current = head;

        while(current != null){
            if(visited.contains(current)){
                return true; //Cycle detected
            }
            visited.add(current);
            current = current.next;
        }
        return false; //No Cycle
    }
}
