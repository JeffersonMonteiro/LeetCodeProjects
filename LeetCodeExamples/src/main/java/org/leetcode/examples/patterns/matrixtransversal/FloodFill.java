package org.leetcode.examples.patterns.matrixtransversal;

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        // If the starting cell is already newColor, no need to do anything
        if (oldColor == newColor) {
            return image;
        }

        // Start recursive DFS
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        // Base case: check if the cell is out of bounds or the color is not the old color
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }

        // Change the current cell to the new color
        image[row][col] = newColor;

        // Recursively call dfs in all 4 directions
        dfs(image, row + 1, col, oldColor, newColor); // Down
        dfs(image, row - 1, col, oldColor, newColor); // Up
        dfs(image, row, col + 1, oldColor, newColor); // Right
        dfs(image, row, col - 1, oldColor, newColor); // Left
    }

    public static void main(String[] args) {
        FloodFill solver = new FloodFill();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;
        int[][] result = solver.floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

}
