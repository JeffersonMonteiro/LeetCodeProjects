package org.leetcode.examples.tree;

import org.leetcode.examples.tree.model.TreeNode;

import java.util.*;

public class TreeOperations {

    public static TreeNode buildTree(TreeNode treeNodeRoot) {
        Scanner sca = new Scanner(System.in);
        System.out.println("Enter the Data:");
        int data = sca.nextInt();

        treeNodeRoot = new TreeNode(data);
        if (data == -1) {
            return null;
        }

        System.out.println("Enter data for inserting in left " + data);
        treeNodeRoot.left = buildTree(treeNodeRoot.left);
        System.out.println("Enter data for inserting in right " + data);
        treeNodeRoot.right = buildTree(treeNodeRoot.right);
        return treeNodeRoot;
    }

    //Level Order Traversal --> show by level
    public static List<List<Integer>> recursiveLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return res;

        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> subres = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);

                subres.add(q.poll().data);
            }
            res.add(subres);
        }
        return res;
    }

    //ROOT -> LEFT -> RIGHT
    public static List<Integer> recursivePreorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    //ROOT -> LEFT -> RIGHT
    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.data);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    //LEFT -> ROOT -> RIGHT
    public static List<Integer> recursiveInorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    public static void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;

        inorder(root.left, res);
        res.add(root.data);
        inorder(root.right, res);
    }

    //LEFT -> RIGHT -> ROOT
    public static List<Integer> recursivePostorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    public static void postorder(TreeNode root, List<Integer> res){
        if(root == null) return;

        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.data);
    }


    public static List<Integer> iterativePreorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            res.add(root.data);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return res;
    }


    public static List<Integer> iterativeInorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }

    public static List<Integer> iterativePostorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().data);
        }
        return res;
    }

    public static void main(String[] args) {
//        TreeNode root = null;
//        root = buildTree(root);
//        System.out.println(root);

//        L1 -->    (3)
//                /     \
//        L2 --> (6)     (9)
//              /   \    /   \
//        L3 -(10)  (8) (5)  (2)

        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(6);
        head.right = new TreeNode(9);
        head.left.right = new TreeNode(8);
        head.left.left = new TreeNode(10);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(2);

        //recursiveLevelOrder(head).stream().flatMap(g -> g.stream()).toList().forEach(System.out::println);

        //recursivePreorderTraversal(head).forEach(System.out::println);

        //recursiveInorderTraversal(head).forEach(System.out::println);

        //recursivePostorderTraversal(head).forEach(System.out::println);

        //iterativePreorderTraversal(head).forEach(System.out::println);

        //iterativeInorderTraversal(head).forEach(System.out::println);

        //iterativePostorderTraversal(head).forEach(System.out::println);binary
    }
}
