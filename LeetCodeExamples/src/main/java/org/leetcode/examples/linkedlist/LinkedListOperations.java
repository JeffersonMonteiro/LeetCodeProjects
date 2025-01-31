package org.leetcode.examples.linkedlist;

// Iterative Java program to reverse a linked list

import org.leetcode.examples.linkedlist.model.*;
import org.leetcode.examples.linkedlist.oldVersion.LinkedList;

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

    // This function prints the contents
    // of the linked list starting from the head
    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        printList(head);

        // ******INSERTION******
        insert(head, 80);
        System.out.print("\n");
        printList(head);

        head = reverseList(head);

        System.out.print("\n");
        System.out.print("\nReversed Linked List:");
        printList(head);


        // Delete node with value 4
        // In this case the key is present ***in the
        // middle***
        deleteByKey(head, 4);

        // Print the LinkedList
        System.out.print("\n");
        printList(head);

        // Delete node with value 10
        // In this case the key is ***not present***
        deleteByKey(head, 10);

        // Print the LinkedList
        System.out.print("\n");
        printList(head);

        //
        // ******DELETION AT POSITION******
        //

        // Delete node at position 0
        // In this case the key is ***at head***
        head = deleteAtPosition(head, 0);

        // Print the LinkedList
        System.out.print("\n");
        printList(head);

        // Delete node at position 2
        // In this case the key is present ***in the
        // middle***
        deleteAtPosition(head, 2);

        // Print the LinkedList
        System.out.print("\n");
        printList(head);

        // Delete node at position 10
        // In this case the key is ***not present***
        deleteAtPosition(head, 10);

        // Print the LinkedList
        System.out.print("\n");
        printList(head);
    }

}
