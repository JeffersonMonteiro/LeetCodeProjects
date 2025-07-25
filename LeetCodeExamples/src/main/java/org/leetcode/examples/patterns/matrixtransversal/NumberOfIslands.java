package org.leetcode.examples.patterns.matrixtransversal;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    //#### DFS (Recursive) Implementation in Java
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        // Traverse every cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // If the cell is land ('1'), it's a new island
                if (grid[row][col] == '1') {
                    numIslands++; // Increment the island count
                    dfs(grid, row, col); // Mark the island as visited
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        // Base case: if out of bounds or the cell is water ('0'), return
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // Mark the cell as visited by changing its value to '0'
        grid[row][col] = '0';

        // Explore all 4 directions (up, down, left, right)
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }

    //#### BFS Implementation in Java
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        // Traverse the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // If the cell is land ('1'), process the island
                if (grid[row][col] == '1') {
                    numIslands++; // Increment the number of islands
                    bfs(grid, row, col); // Perform BFS to mark the island
                }
            }
        }

        return numIslands;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = '0'; // Mark the starting cell as visited

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            // Explore all 4 directions
            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                // Check if the new cell is within bounds and is land ('1')
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == '1') {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // Mark as visited
                }
            }
        }
    }




    public static void main(String[] args) {
        NumberOfIslands solver = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result = solver.numIslands(grid);

        System.out.println("Number of Islands: " + result); // Output: 3


        int resultBFS = solver.numIslandsBFS(grid);

        System.out.println("Number of Islands: " + resultBFS); // Output: 3

    }

}
