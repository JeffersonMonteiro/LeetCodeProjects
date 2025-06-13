package org.leetcode.examples.patterns.topkelements;

import java.util.PriorityQueue;

public class TopkLargestElementsMinHeapApproach {

    public int[] kLargestElementsMinHeapApproach(int[] nums, int k) {
        // Min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first K elements into the min heap
        for(int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract the top K largest elements from the min heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
