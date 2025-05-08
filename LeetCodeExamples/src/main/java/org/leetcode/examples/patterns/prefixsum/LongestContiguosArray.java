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
        int zero = 0, one = 0;
        int res = 0;

        HashMap<Integer, Integer> diffIndex = new HashMap<>(); // count[1] - count[0] -> diff_index

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                one++;
            }

            if (!diffIndex.containsKey(one - zero)) {
                diffIndex.put(one - zero, i);
            }

            if (one == zero) {
                res = one + zero;
            } else {
                int idx = diffIndex.get(one - zero);
                res = Math.max(res, i - idx);
            }
        }

        return res;
    }
}

