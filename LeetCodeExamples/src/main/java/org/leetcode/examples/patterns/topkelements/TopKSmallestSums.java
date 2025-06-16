package org.leetcode.examples.patterns.topkelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopKSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap to store the pairs based on their sums
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        // Add the first k pairs from nums1 and the first element of nums2
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract the smallest k pairs
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int sum = current[0], i = current[1], j = current[2];

            // Add the current pair to the result
            result.add(Arrays.asList(nums1[i], nums2[j]));

            // If there's a next element in nums2, add the next pair to the heap
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        TopKSmallestSums solver = new TopKSmallestSums();

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        System.out.println("K Smallest Pairs: " + solver.kSmallestPairs(nums1, nums2, k));
    }


}
