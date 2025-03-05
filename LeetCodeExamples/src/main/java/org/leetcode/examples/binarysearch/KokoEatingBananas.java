package org.leetcode.examples.binarysearch;

//Koko loves to eat bananas. There are N piles of bananas, the i-th pile has piles[i] bananas.
//The guards have gone and will come back in H hours. Koko can decide her bananas-per-hour eating speed of K.
//Each hour, she chooses some pile of bananas, and eats K bananas from that pile. If the pile has less than K bananas,
//she eats all of them instead, and won't eat any more bananas during this hour.


//Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
//Return the minimum integer K such that she can eat all the bananas within H hours.
//
//
//Example :
//
//
//Input: piles = [3,6,7,11], H = 8
//Output: 4
//Input: piles = [30,11,23,4,20], H = 5
//Output: 30
//Input: piles = [30,11,23,4,20], H = 6
//Output: 23
//
//Very similar to LC 1011 and LC 410 mentioned above. Let's design a feasible function, given an input speed,
//determine whether Koko can finish all bananas within H hours with hourly eating speed speed. Obviously,
//the lower bound of the search space is 1, and upper bound is max(piles), because Koko can only choose
//one pile of bananas to eat every hour.

import java.util.Arrays;
import java.util.List;

public class KokoEatingBananas {

    public int minEatingSpeed(List<Integer> piles, int H) {
        int left = 1, right = max(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean feasible(List<Integer> piles, int speed, int H) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile - 1) / speed + 1;
        }
        return totalHours <= H;
    }

    private int max(List<Integer> piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(Arrays.asList(30,11,23,4,20),3)
                + " Bananas/hour to eat all bananas from the piles");
    }
}
