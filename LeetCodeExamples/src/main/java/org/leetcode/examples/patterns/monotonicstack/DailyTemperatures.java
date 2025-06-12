package org.leetcode.examples.patterns.monotonicstack;

import java.util.Stack;

public class DailyTemperatures {

    //Time complexity O(n) -- BEST PERFORMANCE FOR HUGE ARRAYS
    //Give a list of daily temperatures, determine how many days you'll have to wait
    // for a warmer day
    static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];  //Result Array with 0s
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current temperature is warmer than the
            // temperature at stack top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); //Pop the previous day's index
                result[prevIndex] = i - prevIndex; // Calculate the wait time
            }
            stack.push(i); // Push current index onto the stack
        }
        return result; //return the computed results
    }
}
