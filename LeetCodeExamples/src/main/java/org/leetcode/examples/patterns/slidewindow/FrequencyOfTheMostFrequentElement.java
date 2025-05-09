package org.leetcode.examples.patterns.slidewindow;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        int [] nums = {2, 1, 5, 1, 3, 2};

        int K = 3;

        System.out.println(maxFrequency(nums, K));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int result = 0;
        long total = 0;

        for (int right = 0; right < nums.length; right++) {
            long currentRight = nums[right];
            total += nums[right];

            while ((right - left + 1) * currentRight - total > k) {
                total -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }


    public static int maxFrequencyOption2(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = 0, result = 0;
        long total = 0;

        while (right < nums.length) {
            long current =  nums[right];
            total += nums[right];

            while ((right - left + 1) * current - total > k) {
                total -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
