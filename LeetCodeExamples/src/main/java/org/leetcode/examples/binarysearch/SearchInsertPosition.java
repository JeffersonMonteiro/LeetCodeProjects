package org.leetcode.examples.binarysearch;

//Given a sorted array and a target value, return the index if the target is found.
//If not, return the index where it would be if it were inserted in order.
//You may assume no duplicates in the array.
//
//Example:
//
//Input: [1,3,5,6], 5
//Output: 2
//Input: [1,3,5,6], 2
//Output: 1
//Very classic application of binary search. We are looking for the minimal k value
//satisfying nums[k] >= target, and we can just copy-paste our template.
//Notice that our solution is correct regardless of whether the input array nums has duplicates.
//Also notice that the input target might be larger than all elements in nums and therefore needs
//to placed at the end of the array. That's why we should initialize right = len(nums) instead of right = len(nums) - 1.


import java.util.Arrays;
import java.util.List;

public class SearchInsertPosition {

    public int searchInsert(List<Integer> nums, int target) {
        int left = 0, right = nums.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(Arrays.asList(1, 2, 3, 4, 5, 6,  8, 9, 10),7));
        System.out.println(new SearchInsertPosition().searchInsert(Arrays.asList(1, 2, 3, 4, 5, 6,  8, 9, 10),6));
    }
}
