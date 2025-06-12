package org.leetcode.examples.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsSum {

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(input);

        for (List<Integer> item : result) {
            System.out.println(item);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int num = 0; num < nums.length; num++) {
            if (num > 0 && nums[num] == nums[num - 1]) {
                continue;
            }

            int left = num + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[num] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[num], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
