package org.leetcode.examples.patterns.prefixsum;

import java.util.HashMap;

public class SubarraySumsDivisibleOrMultiplyByK {


    //To modify the solution to work with subarray sums **equal to any multiple
    // of `K`** (instead of strictly divisible by `K`), the logic does not fundamentally change.
    // Multiples of `K` are inherently tied to divisibility by `K`, so the same remainder-tracking mechanism
    // works directly, as a subarray sum that is divisible by `K` is by definition equal to some multiple of `K`.
    //This means we can reuse the same implementation, but with your clearer intention to make it explicit that
    // it works for detecting subarray sums that equal any multiple of `K`.


    public int subarraysDivByKUsingHashMap(int[] nums, int k) {
        int prefixSumCount = 0; // Tracks the cumulative sum
        int countSubArrays = 0; // Total count of subarrays divisible by k
        HashMap<Integer, Integer> prefixSumRemainderFrequency = new HashMap<>();

        // Initialize the map with remainder 0 and frequency 1 for the base case
        prefixSumRemainderFrequency.put(0, 1);

        for (int numItem : nums) {
            // Update cumulative sum
            prefixSumCount += numItem;

            // Compute remainder of the current prefix sum
            int remainder = prefixSumCount % k;

            // Normalize negative remainders to positive
            remainder = (remainder + k) % k;

            // If this remainder has been seen before, it means there are subarrays ending
            // at the current index whose sum is divisible by k
            if (prefixSumRemainderFrequency.containsKey(remainder)) {
                countSubArrays += prefixSumRemainderFrequency.get(remainder);
            }

            // Update the frequency of the current remainder in the map
            prefixSumRemainderFrequency.put(remainder, prefixSumRemainderFrequency.getOrDefault(remainder, 0) + 1);
        }

        return countSubArrays;
    }

    //This solution is faster than use HashMap to add the remainder value
    public int subarraysDivByKUsingArray(int[] nums, int k) {
        int prefixSumCount = 0; // Tracks the cumulative sum
        int countSubArrays = 0; // Total count of subarrays divisible by k
        int[] remainderFrequency = new int[k]; // Array to track frequencies of each remainder

        // Initialize the base case: remainder 0 appears once
        remainderFrequency[0] = 1;

        for (int numItem : nums) {
            // Update cumulative sum
            prefixSumCount += numItem;

            // Compute remainder of the current prefix sum
            int remainder = prefixSumCount % k;

            // Normalize negative remainders to positive
            if (remainder < 0) {
                remainder += k;
            }

            // Add the frequency of this remainder to the result
            countSubArrays += remainderFrequency[remainder];

            // Increment the frequency of this remainder
            remainderFrequency[remainder]++;
        }

        return countSubArrays;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleOrMultiplyByK solver = new SubarraySumsDivisibleOrMultiplyByK();
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(solver.subarraysDivByKUsingHashMap(nums, k));
        System.out.println(solver.subarraysDivByKUsingArray(nums, k));

    }
}
