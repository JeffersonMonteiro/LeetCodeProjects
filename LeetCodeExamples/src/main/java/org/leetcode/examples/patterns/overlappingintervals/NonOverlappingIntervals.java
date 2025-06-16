package org.leetcode.examples.patterns.overlappingintervals;

import java.util.*;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Step 1: Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Greedy Algorithm to find minimum removals
        int prevEnd = intervals[0][1]; // End time of the previous interval
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            // Step 3: Check for overlap
            if (intervals[i][0] < prevEnd) {
                // Overlapping: Remove this interval (increment count)
                count++;
            } else {
                // No overlap: Update prevEnd to the current interval's end
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solver = new NonOverlappingIntervals();

        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(solver.eraseOverlapIntervals(intervals1)); // Output: 1

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(solver.eraseOverlapIntervals(intervals2)); // Output: 2

        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println(solver.eraseOverlapIntervals(intervals3)); // Output: 0
    }
}
