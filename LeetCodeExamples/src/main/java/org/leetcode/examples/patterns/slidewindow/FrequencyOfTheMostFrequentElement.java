package org.leetcode.examples.patterns.slidewindow;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        int [] nums = {2, 1, 5, 1, 3, 2};

        int K = 3;

        System.out.println(maxFrequency(nums, K));
    }

    public static int maxFrequencyWrongOption(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = 0;
        int result = 0, total = 0;

        while (right < nums.length) {
            total += nums[right];

            while ( (right - left + 1) * nums[right] - total > k) {
                total -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        long curr = 0;

        for (int right = 0; right < nums.length; right++) {
            long target = nums[right];
            curr += target;

            while ((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
