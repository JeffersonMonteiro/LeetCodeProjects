package org.leetcode.examples.binarysearch;

//Given an integer array bloomDay, an integer m and an integer k. We need to make m bouquets. To make a bouquet,
//you need to use k adjacent flowers from the garden. The garden consists of n flowers, the ith flower will bloom in
//the bloomDay[i] and then can be used in exactly one bouquet. Return the minimum number of days you need to wait
//to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
//
//Examples:
//
//Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
//Output: 3
//Explanation: Let's see what happened in the first three days. x means flower bloomed and _ means flower didn't bloom in the garden.
//We need 3 bouquets each should contain 1 flower.

//After day 1: [x, _, _, _, _]   // we can only make one bouquet.
//After day 2: [x, _, _, _, x]   // we can only make two bouquets.
//After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
//Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
//Output: -1

//Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so
//it is impossible to get the needed bouquets and we return -1.

//Now that we've solved three advanced problems above, this one should be pretty easy to do. The monotonicity
//of this problem is very clear: if we can make m bouquets after waiting for d days, then we can definitely
//finish that as well if we wait for more than d days.


import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(List<Integer> bloomDay, int m, int k) {
        if (bloomDay.size() < m * k) {
            return -1;
        }

        int left = 1, right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(bloomDay, mid, k, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean feasible(List<Integer> bloomDay, int days, int k, int m) {
        int bonquets = 0, flowers = 0;
        for (int bloom : bloomDay) {
            if (bloom > days) {
                flowers = 0;
            } else {
                flowers++;
                if (flowers >= k) {
                    bonquets++;
                    flowers = 0;
                }
            }
        }
        return bonquets >= m;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(Arrays.asList(1,10,9,12,5,8,5,2,3,10,2),5,2)
                + " The min days to make a bouquet");
    }
}
