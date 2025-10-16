package org.leetcode.examples.patterns.prefixsum;

import java.util.HashMap;

//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
public class LongestContiguosArray {

    public static void main(String[] args) {
        LongestContiguosArray l = new LongestContiguosArray();
        int[] listInput = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(findMaxLength(listInput));
    }

    public static int findMaxLength(int[] nums) {
        int zero = 0, one = 0;  // Initialize counts for 0's and 1's
        int res = 0; // Result to store the maximum length of the subarray
        HashMap<Integer, Integer> diffIndex = new HashMap<>(); // Map to store the difference (count[1] - count[0]) and its first occurrence index

        for (int i = 0; i < nums.length; i++) { // Loop through the array
            if (nums[i] == 0) { // Update the count based on the element
                zero++; 
            } else {
                one++;
            }

            // If we encounter this difference for the first time, store it in the HashMap
            if (!diffIndex.containsKey(one - zero)) {
                diffIndex.put(one - zero, i);
            }

            // Check if the difference between 1's and 0's is 0
            if (one == zero) {
                res = one + zero; // Update the result for the full array from index 0
            } else {
                int idx = diffIndex.get(one - zero); // Retrieve the first occurrence of the difference
                res = Math.max(res, i - idx); // Update the result with the length of this subarray
            }
        }

        return res; // Return the final result
    }
}