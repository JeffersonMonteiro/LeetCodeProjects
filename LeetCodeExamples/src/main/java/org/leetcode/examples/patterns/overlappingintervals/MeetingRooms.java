package org.leetcode.examples.patterns.overlappingintervals;

// (Maximum Overlapping Intervals)
import java.util.*;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Use a Min-Heap to track meeting end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll(); // Reuse the room (meeting ended)
            }
            minHeap.add(interval[1]); // Add the new meeting
        }

        // Step 3: The size of the heap is the number of rooms required
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRooms solver = new MeetingRooms();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(solver.minMeetingRooms(intervals));
        // Output: 2
    }
}
