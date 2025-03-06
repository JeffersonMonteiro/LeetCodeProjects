package org.leetcode.examples.binarysearch;

//Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and
//divide all the array by it and sum the result of the division. Find the smallest divisor such that
//the result mentioned above is less than or equal to threshold.
//
//Each result of division is rounded to the nearest integer greater than or equal to that element.
//        (For example: 7/3 = 3 and 10/2 = 5). It is guaranteed that there will be an answer.
//
//        Example :
//
//Input: nums = [1,2,5,9], threshold = 6
//Output: 5
//
//Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
//If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
//After so many problems introduced above, this one should be a piece of cake.
//We don't even need to bother to design a condition function, because the problem has already
//told us explicitly what condition we need to satisfy.

import java.util.List;

public class FindTheSmallestDivisorGivenThreshold {

    public int smallestDivisor(List<Integer> nums, int threshold) {
        int left = 1, right = max(nums);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (condition(nums, mid, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean condition(List<Integer> nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num - 1) / divisor + 1;
        }
        return sum <= threshold;
    }

    private int max(List<Integer> nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }
}
