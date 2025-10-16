package org.leetcode.examples.patterns.prefixsum;


//Given an array of integers nums and an integer K, return the number of subarrays whose sum equals K
//  0  1  2   3  4
// [1, 2, 3, -2, 4]
//Using the technique from the Sum of elements between two indices, but in this case the sum will be equals K
// prefixSum[right] - prefixSum[left - 1] = K
//But maybe you can have multiple negative numbers on the left, so change the equation
// prefixSum[right] - K = prefixSum[left - 1]


import java.util.HashMap;

public class NumberOfSubArraysWhoseSumEqualsK {

    public static void main(String[] args) {

    }

    public static int subarray(int[] numsArray, int K) {
        int prefixSum = 0; // Keeps track of the cumulative sum of elements
        int count = 0; // Counts the number of subarrays with sum K
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1); // Initializes the hashmap with a base case (prefix sum 0 appears once)

        for (int numItem : numsArray) { // Iterate over each element in the array
            prefixSum += numItem; // Update the cumulative sum

            // Check if the difference between current prefix sum and K has been seen before
            if (prefixSumFrequency.containsKey(prefixSum - K)) {
                count += prefixSumFrequency.get(prefixSum - K); // Increment count by the frequency of (prefixSum - K)
            }

            // Add or update the current prefix sum's frequency in the hashmap
            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }
        return count; // Return the total count of subarrays with sum K
    }
}