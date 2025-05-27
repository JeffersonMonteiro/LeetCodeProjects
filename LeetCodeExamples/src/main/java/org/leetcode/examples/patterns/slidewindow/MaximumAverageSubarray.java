package org.leetcode.examples.patterns.slidewindow;

public class MaximumAverageSubarray {

    public static void main(String[] args) {
        int [] nums = {1,12,-5,-6,50,3};

        int K = 4;

        System.out.println(findMaxAverageSlidingWindow(nums, K));
    }


//    Here’s the key idea:
//
//    Instead of recalculating the sum of the entire subarray for every position:
//
//    Use a window of size k that slides one element at a time.
//
//    Update the window sum dynamically by:
//
//    Subtracting the element that’s leaving the window.
//
//    and Adding the element that’s entering the window.
//
//    This eliminates redundant calculations and processes the array in a single pass.

    public static double findMaxAverageSlidingWindow(int[] nums, int k) {
        //int n = nums.length;

        // Compute the windowSum of the first 'k' elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // Initialize maxSum as the windowSum of the first window
        int maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];      // Add new element entering window --> Update Window Sum
            //windowSum -= nums[i - k];  // Remove element leaving window
            maxSum = Math.max(maxSum, windowSum); // Update maxSum
        }

        // Return maximum average
        return (double) maxSum / k;
    }
}
