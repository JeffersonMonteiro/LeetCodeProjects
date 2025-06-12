package org.leetcode.examples.patterns.fastandslowpointers;


import org.leetcode.examples.linkedlist.model.ListNode;

//Using dummy node to solve this problem
public class ReverseLinkedListBetween {

    static ListNode reverseListBetween(ListNode head, int left, int right) {

        // Reach node at the position
        ListNode dummy = new ListNode(0, head);
        ListNode leftPrev = dummy;
        ListNode curr = head;

        // 1) Reach node at the position "left"
        for (int i = 0; i < left - 1; i++) {
            leftPrev = curr;
            curr = curr.next;

        }

        //  Now cur="left", leftPrev="node before left"
        // 2) reverse from left to right (quantity of nodes + 1)
        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode tmpNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNext;
        }

        //3) Update the pointers
        leftPrev.next.next = curr; // cur is node after the "right"
        leftPrev.next = prev;     // prev is "right"
        return  dummy.next;
    }

}
