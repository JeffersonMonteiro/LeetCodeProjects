package org.leetcode.examples.patterns.topkelements;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    /*
     * ********** LeetCode 973 - K Closest Points to Origin (https://leetcode.com/problems/k-closest-points-to-origin/description/) **********
     */
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];  // Squared distance to avoid floating-point operations
    }

    public int[][] kClosestPointsToOriginMaxHeapApproach(int[][] points, int k) {
        // Max heap with custom comparator to compare by distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(getDistance(b), getDistance(a))
        );

        // Iterate through all points
        for (int[] point : points) {
            maxHeap.add(point);  // Add the current point to the heap

            // If the heap exceeds size K, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();  // Remove the point with the largest distance (root of max heap)
            }
        }

        // Convert the remaining points in the heap to the result array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
