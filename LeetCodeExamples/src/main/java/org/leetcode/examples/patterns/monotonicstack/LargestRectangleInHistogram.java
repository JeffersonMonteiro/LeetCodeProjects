package org.leetcode.examples.patterns.monotonicstack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();  // To store indices of histogram bars
    int maxArea = 0;                       // Variable to store the maximum area
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
        int currentHeight = (i == n) ? 0 : heights[i];  // Use 0 height at the end to process all heights

        while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
            int height = heights[stack.pop()];          // Previous height
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;  // Calculate width
            maxArea = Math.max(maxArea, height * width); // Update the maximum area
        }

        stack.push(i); // Push the current index onto the stack
    }

    return maxArea; // Return the largest rectangle area
}


}