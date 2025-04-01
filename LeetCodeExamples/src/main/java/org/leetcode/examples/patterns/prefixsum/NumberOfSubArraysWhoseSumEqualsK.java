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
        int prefixSum = 0;
        int count = 0;

        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();

        prefixSumFrequency.put(0, 1);

        for (int numItem : numsArray) {
            prefixSum += numItem;


            if (prefixSumFrequency.containsKey(prefixSum - K)) {
                count += prefixSumFrequency.get(prefixSum - K);
            }

            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
