package org.leetcode.examples.patterns.arrays;


public class MajorityElement {

    // Method to find the majority element
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        // Phase 1: Find a candidate for majority element
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Note: Phase 2 (Validation) is not necessary here because
        // it is assumed by the problem constraints the majority element always exists.

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] numbers = {2, 2, 1, 1, 1, 2, 2};

        // Find and print the majority element
        System.out.println("Majority Element: " + obj.majorityElement(numbers));
    }
}

