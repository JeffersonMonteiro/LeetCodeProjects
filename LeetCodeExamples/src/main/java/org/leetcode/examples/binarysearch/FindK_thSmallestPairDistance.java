package org.leetcode.examples.binarysearch;

//Given an integer array, return the k-th smallest distance among all the pairs.
//The distance of a pair (A, B) is defined as the absolute difference between A and B.
//
//Example :
//
//Input:
//nums = [1,3,1]
//k = 1
//Output: 0
//Explanation:
//
//Following are all the pairs. The 1st smallest distance pair is (1,1), and its distance is 0.
//        (1,3) -> 2
//        (1,1) -> 0
//        (3,1) -> 2
//
//Very similar to LC 668 above, both are about finding Kth-Smallest. Just like LC 668,
//We can design an enough function, given an input distance, determine whether there're
//at least k pairs whose distances are less than or equal to distance.
//We can sort the input array and use two pointers (fast pointer and slow pointer, pointed at a pair) to scan it.
//Both pointers go from leftmost end. If the current pair pointed at has a distance less than or equal
//        to distance, all pairs between these pointers are valid (since the array is already sorted),
//we move forward the fast pointer. Otherwise, we move forward the slow pointer. By the time
//both pointers reach the rightmost end, we finish our scan and see if total counts exceed k. Here is the implementation:

import java.util.Arrays;

public class FindK_thSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (enough(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean enough(int[] nums, int distance, int k) {
        int count = 0, i = 0, j = 0;
        int n = nums.length;

        while (i < n || j < n) {
            while (j < n && nums[j] - nums[i] <= distance) {
                j++;
            }
            count += j - i - 1;
            i++;
        }
        return count >= k;
    }
}
