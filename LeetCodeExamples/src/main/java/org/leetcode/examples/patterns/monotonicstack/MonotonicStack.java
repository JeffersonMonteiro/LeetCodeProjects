package org.leetcode.examples.patterns.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    //Useful to find the next greater element
    //Useful to find the next smaller element
    //Useful to find the previous greater element
    //Useful to find the previous smaller element

    //Time complexity O(n) -- BEST PERFORMANCE FOR HUGE ARRAYS
    // Store the index difference (customizable)
    static int[] monotonicStackTemplate(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Initialize result with a placeholder value (e.g., -1).
        // You can change it based on your use case.
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Apply the monotonic stack condition
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int index = stack.pop(); //Remove top element (process it)
                result[index] = i; // Store the index difference (customizable)
            }
            stack.push(i); // Push current element's index onto the stack
        }

        // At this point, any remaining indices in the stack will not have a "next smaller element".
        // Their value in the result will remain as initialized (-1 in this case).

        return result;
    }
}
