package org.leetcode.examples.patterns.binarythreetranversal;

import org.leetcode.examples.tree.model.TreeNode;

public class BinaryTreeMaximumPathSum {
    private static int maxSum = Integer.MIN_VALUE; // Global variable to store the maximum path sum

    public static int maxPathSum(TreeNode root) {
        calculatePathSum(root);
        return maxSum; // Return the max path sum found
    }

    //### Recursive Java Solution
    private static int calculatePathSum(TreeNode node) {
        if (node == null) return 0; // Base case: null node contributes 0 path sum

        // Recursively get the maximum path sum of left and right subtrees
        int leftSum = Math.max(0, calculatePathSum(node.left)); // Only consider non-negative sums
        int rightSum = Math.max(0, calculatePathSum(node.right)); // Only consider non-negative sums

        // Compute the maximum path sum through the current node
        int pathThroughNode = node.data + leftSum + rightSum;

        // Update the global maximum path sum
        maxSum = Math.max(maxSum, pathThroughNode);

        // Return the contribution of this node to its parent
        return node.data + Math.max(leftSum, rightSum); // Use the larger child's contribution
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Path Sum: " + maxPathSum(root)); // Output: 42
    }


}
