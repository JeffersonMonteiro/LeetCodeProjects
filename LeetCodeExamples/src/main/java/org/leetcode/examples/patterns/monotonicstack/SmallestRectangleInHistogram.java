package org.leetcode.examples.patterns.monotonicstack;

import java.util.Stack;

public class SmallestRectangleInHistogram {

    public int smallestRectangleArea(int[] heights) {
        int n = heights.length;

        // Arrays to store the previous and next smaller elements for each bar
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];

        // Fill nextSmaller with a default value of n (indicating no smaller element to the right)
        // Fill prevSmaller with a default value of -1 (indicating no smaller element to the left)
        for (int i = 0; i < n; i++) {
            nextSmaller[i] = n;
            prevSmaller[i] = -1;
        }

        // Monotonic stack to find next smaller element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Clear the stack to reuse for finding previous smaller element
        stack.clear();

        // Monotonic stack to find previous smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        // Calculate the smallest rectangle area
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;
            minArea = Math.min(minArea, area);
        }

        return minArea;
    }

    public static void main(String[] args) {
        SmallestRectangleInHistogram solver = new SmallestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println("Smallest Rectangle Area: " + solver.smallestRectangleArea(heights));
    }

}
