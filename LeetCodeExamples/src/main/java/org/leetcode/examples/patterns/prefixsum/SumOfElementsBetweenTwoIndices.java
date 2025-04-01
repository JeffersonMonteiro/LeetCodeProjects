package org.leetcode.examples.patterns.prefixsum;

public class SumOfElementsBetweenTwoIndices {

    private int[] prefixSum;

    public SumOfElementsBetweenTwoIndices(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.prefixSum = nums;
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}
