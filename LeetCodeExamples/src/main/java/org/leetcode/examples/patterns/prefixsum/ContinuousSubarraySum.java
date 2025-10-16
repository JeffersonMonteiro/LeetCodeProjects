package org.leetcode.examples.patterns.prefixsum;

import java.util.HashMap;

class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        // HashMap to store remainders and their first occurrence index
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Initialize for cases where subarray starts from index 0

        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) return true;
            }
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Update prefix sum

            // Calculate remainder and normalize negative values
            int remainder = prefixSum % k;

            if (remainder < 0) {
                remainder += k;
            }

            // If the remainder already exists in the map
            if (remainderMap.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the remainder and its index if it does not exist
                remainderMap.put(remainder, i);
            }
        }

        return false; // Return false if no good subarray is found
    }

    public static void main(String[] args) {
        ContinuousSubarraySum solver = new ContinuousSubarraySum();
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(solver.checkSubarraySum(nums, k));
    }
}