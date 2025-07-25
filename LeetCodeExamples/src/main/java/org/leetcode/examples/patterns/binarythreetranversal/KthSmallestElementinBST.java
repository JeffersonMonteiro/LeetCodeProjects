package org.leetcode.examples.patterns.binarythreetranversal;

import org.leetcode.examples.tree.model.TreeNode;

public class KthSmallestElementinBST {

    private static int count = 0; // To keep track of the visited nodes
    private static int result = -1; // To store the kth smallest value

    public static int kthSmallest(TreeNode root, int k) {
        // Call a helper method to recurse
        count = 0; // To reset for multiple calls
        inOrderTraversal(root, k);
        return result;
    }

    private static void inOrderTraversal(TreeNode node, int k) {
        if (node == null) return;

        // Traverse left subtree
        inOrderTraversal(node.left, k);

        // Increment count and check if current node is the kth smallest
        count++;
        if (count == k) {
            result = node.data;
            return; // Stop traversal once we find the kth element
        }

        // Traverse right subtree
        inOrderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;
        System.out.println("The " + k + "rd smallest element is " + kthSmallest(root, k)); // Output: 3
    }


    // Recursive Solution (Java):

}
