package org.leetcode.examples.recursion;


import org.leetcode.examples.recursion.model.Node;

import java.util.ArrayList;
import java.util.Stack;

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
        System.out.println("COUNT " + count);
        return count;
    }


    // Actual work start's from here
    public static ArrayList sort(ArrayList<Integer> arr) { // sort function
        // Base Condition
        if (arr.size() == 1) {
            return arr;
        }
        // Hypothesis
        int temp = arr.get(arr.size() - 1); // getting 2 out
        arr.remove(arr.size() - 1); // removing it from array
        sort(arr); // sorting the array from [5,1,0] -> [0,1,5]

        insert(arr, temp);
        return arr;
    }

    public static ArrayList insert(ArrayList<Integer> arr, int temp) { // insert function
        // Base Condition
        if (arr.size() == 0 || temp >= arr.get(arr.size() - 1)) { // checking if let say we have 6 in temp & 6 is greater then 5
            arr.add(temp); // we will simply add it into our array
            return arr; // and return it
        }
        // Hypothesis
        int val = arr.get(arr.size() - 1); // getting 5 out
        arr.remove(arr.size() - 1); // removing 5 from array -> [0,1]
        insert(arr, temp); // inserting 2 to [0,1] which becomes -> [0,1,2]

        // Induction
        arr.add(val); // adding 5 to [0,1,2] which becomes -> [0,1,2,5]
        return arr;
    }

    // Actual work start's from here
    public static Stack<Integer> sortStack(Stack<Integer> st) {
        if (st.size() == 1) return st; // Base Condition
        // Hypothesis
        int temp = st.pop(); // getting 2 out
        sortStack(st); // sorting the stack from [5,1,0] -> [0,1,5]

        return insertElementAtStack(st, temp);
    }

    public static Stack<Integer> insertElementAtStack(Stack<Integer> st, int temp) {
        // Base Condition
        if (st.size() == 0 || temp >= st.peek()) { // checking if let say we have 6 in temp & 6 is greater then 5
            st.push(temp); // we will simply add it into our stack
            return st;
        }
        // Hypothesis
        int val = st.pop(); // getting 5 out stack becomes -> [0,1]
        insertElementAtStack(st, temp); // insrting 2 to [0,1] which becomes -> [0,1,2]
        // Induction
        st.push(val); // adding 5 to [0,1,2] which becomes -> [0,1,2,5]
        return st;
    }

        // Deletes middle of stack of size
    // n. Curr is current item number
    static void deleteMid(Stack<Integer> st, int n, int curr)
    {

        // If stack is empty or all items
        // are traversed
        if (st.empty() || curr == n)
            return;

        // Remove current item
        Integer x = st.pop();

        // Remove other items
        deleteMid(st, n, curr+1);

        // Put all items back except middle
        if (curr != n / 2)
            st.push(x);
    }

//    public static void reverse(Stack<Integer> st) {
//        // Base Condition
//        if(st.size() == 1) return ;
//
//        // Hypothesis
//        int temp = st.pop(); // removing 5 from stack
//        reverse(st); // reversing the stack
//        insert(st, temp); // func. call
//    }
//    public static Stack<Integer> solve(Stack<Integer> st, int temp) {
//        // Base Condition
//        if(st.size() == 0){
//            st.push(temp);
//            return st;
//        }
//
//        // Hypothesis
//        int val = st.pop(); // removing 1 from stack
//        insert(st, temp); // inserting 5 to stack;
//
//        // Induction
//        st.push(val); // inserting 1 to stack
//        return st;
//    }

//    public static void midDel(Stack<Integer> st) {
//        // Base Condition
//        if (st.size() == 0)
//            return ;
//
//        // Hypothesis
//        int k = st.size() / 2 + 1; // calculating mid
//        solve(st, k); // func. call
//    }
//
//    public static Stack<Integer> solve(Stack<Integer> st, int k) {
//        // Base Condition
//        if (st.size() == 1) {
//            st.pop();
//            return st;
//        }
//
//        // Hypothesis
//        int temp = st.pop(); // removing 5 from stack
//        solve(st, k - 1);
//
//        // Induction
//        st.push(temp);
//        return st;
//    }

    public static void main(String[] args) {
//        solveValueToN(7);
//        System.out.println("\n");
//        solveNToValue(7);
//        System.out.println("\n");
//        System.out.println("\n");
//        // Representation of the input tree:
//        //     12
//        //    /  \
//        //   8   18
//        //  / \
//        // 5   11
//        Node root = new Node(12);
//        root.left = new Node(8);
//        root.right = new Node(18);
//        root.left.left = new Node(5);
//        root.left.right = new Node(11);
//
//        System.out.println(maxDepth(root));

//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(11, 8, 9, 3, 0, 1, 2));
//        System.out.println(sort(arr));

        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(1);
        st.push(7);
        st.push(2);
        st.push(8);
        st.push(0);

        System.out.println("Stack before:");
        for (Integer s : st) {
            System.out.print(s + " ");
        }

//        System.out.println("\nStack after sorting:");
//        Stack<Integer> sorted = sortStack(st);
//        for (Integer i : sorted) {
//            System.out.print(i + " ");
//        }

        System.out.println("\nStack after has is middle element removed:");
        deleteMid(st, st.size(), 0);
        //midDel(st);
        for (Integer i : st) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }





}
