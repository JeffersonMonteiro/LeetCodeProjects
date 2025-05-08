package org.leetcode.examples.patterns.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class LongestContiguosArray {

    public static void main(String[] args) {
        LongestContiguosArray l = new LongestContiguosArray();
        int [] listInput = {0,1,1,1,1,1,0,0,0};
        l.findMaxLength(listInput);
    }

    public int findMaxLength(int[] nums) {
        List<Integer> countZeros = new ArrayList<>();
        List<Integer> countOnes = new ArrayList<>();
        int countSize = 0;

        for (int num : nums) {
            if (num == 0) {
                countZeros.add(num);
            } else {
                countOnes.add(num);
            }

            if (countZeros.size() == countOnes.size()) {
                countSize += countZeros.size() + countOnes.size();
            }
        }
        return countSize;

    }
}
