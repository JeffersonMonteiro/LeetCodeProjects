package org.leetcode.examples.patterns.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStackNextGreaterElement {

    //Time complexity O(n) -- BEST PERFORMANCE FOR HUGE ARRAYS
    //Find the next Greater element for each number in an array
    static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; //Output Array

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Apply the monotonic stack condition
            //The next Greater element
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop(); //Pop Element
                result[index] = nums[i]; // Store the index of the next greater element (is the NGE)
            }
            stack.push(i); // Push current index to the stack
        }
        return result;
    }
}
