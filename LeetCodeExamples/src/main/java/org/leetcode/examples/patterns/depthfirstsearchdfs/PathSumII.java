package org.leetcode.examples.patterns.depthfirstsearchdfs;

import org.leetcode.examples.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        // Add the current node to the path
        path.add(node.data);

        // Check if we reached a leaf node and the path sum is the target sum
        if (node.left == null && node.right == null && node.data == targetSum) {
            result.add(new ArrayList<>(path)); // Add the current path to the result
        } else {
            // Recurse into the left and right subtrees
            findPaths(node.left, targetSum - node.data, path, result);
            findPaths(node.right, targetSum - node.data, path, result);
        }

        // Backtrack to explore other paths
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSumII solution = new PathSumII();
        System.out.println(solution.pathSum(root, 22));
        // Output: [[5, 4, 11, 2], [5, 8, 4, 5]]
    }

}
