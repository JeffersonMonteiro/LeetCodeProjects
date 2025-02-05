package org.leetcode.examples.linkedlist;

// Iterative Java program to reverse a linked list

import org.leetcode.examples.linkedlist.model.*;
import org.leetcode.examples.linkedlist.oldVersion.LinkedList;

import java.util.Stack;

// Given the head of a list, reverse the list and return the
// head of reversed list
public class LinkedListOperations {

    static Node reverseList(Node head) {

        // Initialize three pointers: curr, prev and next
        Node curr = head, prev = null, next;

        // Traverse all the nodes of Linked List
        while (curr != null) {

            // Store next
            next = curr.next;

            // Reverse current node's next pointer
            curr.next = prev;

            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }

        // Return the head of reversed linked list
        return prev;
    }

    // Method to insert a new node
    public static Node insert(Node list, int data) {
        Node head = list;
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list == null) {
            head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return head;
    }

    // **************DELETION BY KEY**************

    // Method to delete a node in the LinkedList by KEY
    public static Node deleteByKey(Node list,
                                   int key) {
        // Store head node
        Node currNode = list;
        Node prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.data == key) {
            list = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            // Display the message
            System.out.print("\n");
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.print("\n");
            System.out.println(key + " not found");
        }

        // return the List
        return list;
    }

    // **************DELETION AT A POSITION**************

    //    // Method to delete a node in the LinkedList by POSITION
    public static Node deleteAtPosition(Node list, int index) {
        // Store head node
        Node currNode = list;
        Node prev = null;

        //
        // CASE 1:
        // If index is 0, then head node itself is to be
        // deleted

        if (index == 0 && currNode != null) {
            list = currNode.next; // Changed head

            // Display the message
            System.out.print("\n");
            System.out.println(
                    index + " position element deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the
        // size of LinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required
                // position Unlink currNode from linked list
                prev.next = currNode.next;

                // Display the message
                System.out.print("\n");
                System.out.println(
                        index + " position element deleted");
                break;
            } else {
                // If current position is not the index
                // continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // If the position element was found, it should be
        // at currNode Therefore the currNode shall not be
        // null
        //
        // CASE 3: The index is greater than the size of the
        // LinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.print("\n");
            System.out.println(
                    index + " position element not found");
        }

        // return the List
        return list;
    }

    public static Node middleNode(Node head) {
        // Base Condition
        if (head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    static boolean detectLoop(Node head) {

        // Fast and slow pointers initially points to the head
        Node slow = head, fast = head;

        // Loop that runs while fast and slow pointer are not
        // null and not equal
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If fast and slow pointer points to the same node,
            // then the cycle is detected
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

//    // Function to check if the linked list
//    // is palindrome or not
////    The idea is to initialize an empty stack and start traversing from the head node. Push all the nodes
////    into the stack while traversing till end. Again traverse the linked list and compare the popped node’s data
////    with the current node data. If both the data are not equal return false, else when stack becomes empty,
////    it means we reach to the end node. return true, as linked list is a palindrome.
//    //NAIVE APPROACH
//    static boolean isPalindrome(Node head) {
//        Node currNode = head;
//        Stack<Integer> s = new Stack<>();
//
//        // Push all elements of the list to the stack
//        while (currNode != null) {
//            s.push(currNode.data);
//            currNode = currNode.next;
//        }
//
//        // Iterate in the list again and check
//        // by popping from the stack
//        while (head != null) {
//
//            // Get the topmost element
//            int c = s.pop();
//
//            // Check if data is not same as
//            // popped element
//            if (head.data != c) {
//                return false;
//            }
//
//            // Move ahead
//            head = head.next;
//        }
//
//        return true;
//    }
//
//


    // Function to check whether the list is palindrome
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;

        while (fast.next != null
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head2 = reverseList(slow.next);
        slow.next = null;

        boolean ret = isIdentical(head, head2);

        head2 = reverseList(head2);
        slow.next = head2;

        return ret;
    }

    // Function to check if two lists are identical
    static boolean isIdentical(Node n1, Node n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    // Function to get the intersection point of two linked lists
    static Node intersectPoint(Node head1, Node head2) {

        // Maintaining two pointers ptr1 and ptr2
        // at the heads of the lists
        Node ptr1 = head1;
        Node ptr2 = head2;

        // If any one of the heads is NULL, there is no intersection
        if (ptr1 == null || ptr2 == null)
            return null;

        // Traverse through the lists until both pointers meet
        while (ptr1 != ptr2) {

            // Move to the next node in each list and if the one
            // pointer reaches NULL, start from the other linked list
            ptr1 = (ptr1 != null) ? ptr1.next : head2;
            ptr2 = (ptr2 != null) ? ptr2.next : head1;
        }

        // Return the intersection node, or null if no intersection
        return ptr1;
    }


    // This function prints the contents
    // of the linked list starting from the head
    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {

//        // Create a hard-coded linked list:
//        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(3);
//        head.next.next.next.next.next = new Node(2);
//        head.next.next.next.next.next.next = new Node(1);
//
//        System.out.print("Given Linked list:");
//        printList(head);

//        // ******INSERTION******
//        insert(head, 80);
//        System.out.print("\n");
//        printList(head);
//
//        head = reverseList(head);
//
//        System.out.print("\n");
//        System.out.print("\nReversed Linked List:");
//        printList(head);
//
//
//        // Delete node with value 4
//        // In this case the key is present ***in the
//        // middle***
//        deleteByKey(head, 4);
//
//        // Print the LinkedList
//        System.out.print("\n");
//        printList(head);
//
//        // Delete node with value 10
//        // In this case the key is ***not present***
//        deleteByKey(head, 10);
//
//        // Print the LinkedList
//        System.out.print("\n");
//        printList(head);
//
//        //
//        // ******DELETION AT POSITION******
//        //
//
//        // Delete node at position 0
//        // In this case the key is ***at head***
//        head = deleteAtPosition(head, 0);
//
//        // Print the LinkedList
//        System.out.print("\n");
//        printList(head);
//
//        // Delete node at position 2
//        // In this case the key is present ***in the
//        // middle***
//        deleteAtPosition(head, 2);
//
//        // Print the LinkedList
//        System.out.print("\n");
//        printList(head);
//
//        // Delete node at position 10
//        // In this case the key is ***not present***
//        deleteAtPosition(head, 10);
//
//        // Print the LinkedList
//        System.out.print("\n");
//        printList(head);

//        head = middleNode(head);
//
//        // Print the LinkedList
//        System.out.print("\n");
//        printList(head);

//        // Create a loop
//        head.next.next.next = head.next;
//
//        if (detectLoop(head)) {
//            System.out.print("\n");
//            System.out.println("true");
//        } else {
//            System.out.print("\n");
//            System.out.println("false");
//        }

//        if (isPalindrome(head)) {
//            System.out.print("\n");
//            System.out.println("true");
//        } else {
//            System.out.print("\n");
//            System.out.println("false");
//        }

        // creation of first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        // 15 is the intersection point
        head2.next.next.next = head1.next;

        Node intersectionPoint = intersectPoint(head1, head2);

        if (intersectionPoint == null)
            System.out.println("-1");
        else
            System.out.println(intersectionPoint.data);
    }
}
