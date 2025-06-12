package org.leetcode.examples.patterns.fastandslowpointers;

import org.leetcode.examples.linkedlist.model.ListNode;

public class ReverseLinkedListNodesInPairs {

    static ListNode reverseListInPairs(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            //save pointers
            ListNode nextPair = curr.next.next;
            ListNode second = curr.next;

            //reverse this pair
            second.next = curr;
            curr.next = nextPair;
            prev.next = second;

            //Update pointers
            prev = curr;
            curr = nextPair;
        }
        //Return the dummy pointing to the head
        return dummy.next;
    }
}
