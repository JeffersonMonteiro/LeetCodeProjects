package org.leetcode.examples.patterns.fastandslowpointers;

import org.leetcode.examples.linkedlist.model.Node;

public class ReverseLinkedList {

    static Node reverseList(Node head) {

        // Initialize three pointers: curr, prev and next
        Node curr = head;
        Node prev = null;
        // Traverse all the nodes of Linked List
        while (curr != null) {
            // Store next
            Node next = curr.next;
            // Reverse current node's next pointer
            curr.next = prev;
            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }

        // Return the head of reversed linked list
        return prev;
    }
}
