package org.leetcode.examples.patterns.breadthfirstsearchbfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize the queue with all rotting oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) { // Add rotten orange to the queue
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) { // Count fresh oranges
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges, no time is needed
        if (freshCount == 0) return 0;

        // Step 2: Perform multi-source BFS
        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 4 possible directions

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRot = false; // Track if any orange rots in this minute

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0], col = current[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // If the new cell contains a fresh orange, rot it
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark as rotten
                        queue.add(new int[]{newRow, newCol}); // Add to queue
                        freshCount--; // Decrease fresh orange count
                        hasRot = true;
                    }
                }
            }

            // Increment the timer only if at least one orange rotted
            if (hasRot) minutes++;
        }

        // Step 3: Check if there are any fresh oranges left
        return (freshCount == 0) ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges solver = new RottingOranges();

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println("Minimum minutes to rot all oranges: " + solver.orangesRotting(grid));
    }

}
