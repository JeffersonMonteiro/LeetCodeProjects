package org.leetcode.examples.recursion;


import org.leetcode.examples.recursion.model.Node;

import javax.swing.tree.TreeNode;

public class Recursion {

    //Que. Print 1 to n And that will be 1,2,3,4,5,6,7
    public static void solveValueToN(int n) {
        // Base condition
        if (n == 0) return;
        solveValueToN(n - 1); // Hypothesis
        System.out.println(n); // Induction
    }

    //no.s from 7 to 1. And that will be 7,6,5,4,3,2,1
    public static void solveNToValue(int n) {
        // Base condition
        if (n == 0) return;
        System.out.println(n); // Induction
        solveNToValue(n - 1); // Hypothesis
    }

    // Returns height which is the number of edges
    // along the longest path from the root node down
    // to the farthest leaf node.
    public static int maxDepth(Node root) {
        // Base Condition
        if (root == null) return -1;
        // Hypothesis
        int left = maxDepth(root.left);
        System.out.println("LEFT DATA:" + root.data);
        int right = maxDepth(root.right);
        System.out.println("RIGHT DATA:" + root.data);
        // Induction
        int count = Math.max(left, right) + 1;
        System.out.println("COUNT "+count);
        return count;
    }

    public static void main(String[] args) {
        solveValueToN(7);
        System.out.println("\n");
        solveNToValue(7);
        System.out.println("\n");
        System.out.println("\n");
        // Representation of the input tree:
        //     12
        //    /  \
        //   8   18
        //  / \
        // 5   11
        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(5);
        root.left.right = new Node(11);

        System.out.println(maxDepth(root));
    }


}
