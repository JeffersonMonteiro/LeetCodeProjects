package org.leetcode.examples.patterns.fastandslowpointers;

import java.util.HashSet;

public class FindDuplicateNumbers {

    public int findDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        int pointer = 0;
        for (int num : nums) {
            pointer = num;
            if (!numbers.contains(pointer)) {
                numbers.add(pointer);
            } else {
                return pointer;
            }
        }
        return 0;
    }
}
