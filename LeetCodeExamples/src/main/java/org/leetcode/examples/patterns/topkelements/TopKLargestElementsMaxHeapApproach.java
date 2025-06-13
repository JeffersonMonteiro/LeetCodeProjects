package org.leetcode.examples.patterns.topkelements;

import java.util.Collections;
import java.util.PriorityQueue;

public class TopKLargestElementsMaxHeapApproach {

    /*
     * ********** K Largest Elements **********
     */

    public int[] kLargestElementsMaxHeapApproach(int[] nums, int k) {
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all numbers to the max heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Extract the top K largest elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();  // Extracts the largest element
        }
        return result;
    }
}
