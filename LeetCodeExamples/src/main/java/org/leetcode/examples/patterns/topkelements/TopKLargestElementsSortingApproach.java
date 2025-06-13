package org.leetcode.examples.patterns.topkelements;

import java.util.Arrays;
import java.util.Collections;

public class TopKLargestElementsSortingApproach {

    //It may be useful when you need to:
    // Find the K largest or smallest elements in an array
    //Identifying the K most frequent or least frequent elements in a dataset
    //Dynamically maintaining the top K elements in a real time datastream


    /*
     * ********** K Largest Elements **********
     */

    public int[] kLargestElementsSortingAppraoch(int[] nums, int k) {
        // Step 1: Sort the array in descending order
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArray, Collections.reverseOrder());

        // Step 2: Extract the first K elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = numsArray[i];
        }
        return result;
    }
}

