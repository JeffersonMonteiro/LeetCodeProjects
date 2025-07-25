package org.leetcode.examples.patterns.binarythreetranversal;

import org.leetcode.examples.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

    // Recursive Solution in Java

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        findPaths(root, "", paths);
        return paths;
    }

    private void findPaths(TreeNode node, String path, List<String> paths) {
        if (node == null) return;

        // Append current node's value to the path
        path += node.data;

        // If it's a leaf node, add the path to the result
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            // If not a leaf, continue with left and right child
            path += "->";
            findPaths(node.left, path, paths);
            findPaths(node.right, path, paths);
        }
    }


    //### Iterative Solution in Java
    public List<String> binaryTreePathsIterativeSolution(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        // Stack to maintain nodes and the path string
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();

        nodeStack.push(root);
        pathStack.push(String.valueOf(root.data));

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();

            // If it's a leaf node, add the path to the result
            if (node.left == null && node.right == null) {
                paths.add(path);
            }

            // If there is a right child, push it onto the stack
            if (node.right != null) {
                nodeStack.push(node.right);
                pathStack.push(path + "->" + node.right.data);
            }

            // If there is a left child, push it onto the stack
            if (node.left != null) {
                nodeStack.push(node.left);
                pathStack.push(path + "->" + node.left.data);
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths solution = new BinaryTreePaths();
        List<String> result = solution.binaryTreePaths(root);
        System.out.println(result); // Output: ["1->2->5", "1->3"]


        //### Iterative Solution in Java
        BinaryTreePaths solutionIterative = new BinaryTreePaths();
        List<String> resultIterative = solutionIterative.binaryTreePathsIterativeSolution(root);
        System.out.println(resultIterative); // Output: ["1->2->5", "1->3"]

    }
}
