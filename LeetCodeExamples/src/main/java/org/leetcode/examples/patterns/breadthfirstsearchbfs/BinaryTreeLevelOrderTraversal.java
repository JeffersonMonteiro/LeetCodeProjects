package org.leetcode.examples.patterns.breadthfirstsearchbfs;

import org.leetcode.examples.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    //Here is the BFS-based solution:

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result; // Handle edge case

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in the current level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Dequeue the current node
                currentLevel.add(currentNode.data);

                // Add the left and right children of the current node (if they exist)
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            result.add(currentLevel); // Add the current level to the result
        }

        return result;
    }
    //#### **Zigzag Level Order Traversal**:
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (leftToRight) {
                    currentLevel.addLast(currentNode.data);
                } else {
                    currentLevel.addFirst(currentNode.data);
                }

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Alternate order
        }

        return result;
    }



    public static void main(String[] args) {
        // Create the binary tree:
        //      3
        //     / \
        //    9  20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal solver = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = solver.levelOrder(root);

        System.out.println(result); // Output: [[3], [9, 20], [15, 7]]
    }

}
