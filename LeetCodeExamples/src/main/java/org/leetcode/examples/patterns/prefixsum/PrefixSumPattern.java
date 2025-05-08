package org.leetcode.examples.patterns.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class PrefixSumPattern {

    public static void main(String[] args) {

    }

    //Scenarios to be used

    //Range Sum Queries
    // Compute the sum of elements between two indices frequently

    //SubArray Sum Problems
    //Find or count the number od subarrays that add up to a specific value

    public static int[] calculatePrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }
}
