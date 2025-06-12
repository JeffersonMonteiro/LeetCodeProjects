package org.leetcode.examples.patterns.monotonicstack;

import java.util.Arrays;

public class NextGreaterElementPoorPerformance {


    //OLD TEMPLATE - Time complexity O(n^2) -- POOR PERFORMANCE FOR HUGE ARRAYS
    static int[] monotonicStackTemplate(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Initialize result with a placeholder value (e.g., -1).
        // You can change it based on your use case.
        Arrays.fill(result, -1);


        for (int i = 0; i < n; i++) {
            // Apply the monotonic stack condition
           for(int j = i; j < n; j++){
               if(nums[j] > nums[i]){
                   result[i] = nums[j];
                   break;
               }
           }
        }
        return result;
    }
}
