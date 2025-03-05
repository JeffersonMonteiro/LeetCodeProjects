package org.leetcode.examples.binarysearch;

//Given an array which consists of non-negative integers and an integer m,
//you can split the array into m non-empty continuous subarrays.
//Write an algorithm to minimize the largest sum among these m subarrays.
//
//
//Example:
//
//
//Input:
//nums = [7,2,5,10,8]
//m = 2
//
//Output:
//        18
//
//Explanation:
//There are four ways to split nums into two subarrays. The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.
//If you take a close look, you would probably see how similar this problem is
//with LC 1011 above. Similarly, we can design a feasible function: given an input threshold,
//then decide if we can split the array into several subarrays such that every subarray-sum is less
//than or equal to threshold. In this way, we discover the monotonicity of the problem: if feasible(m) is True,
//then all inputs larger than m can satisfy feasible function.
// You can see that the solution code is exactly the same as LC 1011. (1011. Capacity To Ship Packages Within D Days [Medium])


import java.util.Arrays;
import java.util.List;

public class SplitArrayLargestSum {
    public int splitArray(List<Integer> nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean feasible(List<Integer> nums, int threshold, int m) {
        int count = 1, total = 0;
        for (int num : nums) {
            total += num;
            if (total > threshold) {
                total = num;
                count++;
            }
            if (count > m) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayLargestSum()
                .splitArray(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,5,2,5), 2));
    }
}
