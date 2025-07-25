package org.leetcode.examples.patterns.matrixtransversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    //### **DFS Implementation in Java**
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark all 'O's connected to the borders
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }
            if (board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1);
            }
        }

        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }
            if (board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col);
            }
        }

        // Step 2: Change all remaining 'O's to 'X'
        // and all temporary '#' back to 'O'
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        // Boundary check and check if the cell is already visited or not 'O'
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        // Mark the cell as visited by changing it to '#'
        board[row][col] = '#';

        // Explore all 4 directions
        dfs(board, row + 1, col); // Down
        dfs(board, row - 1, col); // Up
        dfs(board, row, col + 1); // Right
        dfs(board, row, col - 1); // Left
    }

    //### **BFS Implementation in Java**
    public void solveBFS(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add all boundary 'O's to the queue and mark them
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                queue.add(new int[]{row, 0});
            }
            if (board[row][cols - 1] == 'O') {
                queue.add(new int[]{row, cols - 1});
            }
        }

        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                queue.add(new int[]{0, col});
            }
            if (board[rows - 1][col] == 'O') {
                queue.add(new int[]{rows - 1, col});
            }
        }

        // Process the queue using BFS and mark connected 'O's as '#'
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
                continue;
            }

            board[row][col] = '#';

            // Add neighbors to the queue
            queue.add(new int[]{row + 1, col});
            queue.add(new int[]{row - 1, col});
            queue.add(new int[]{row, col + 1});
            queue.add(new int[]{row, col - 1});
        }

        // Change remaining 'O's to 'X' and '#' back to 'O'
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions solver = new SurroundedRegions();

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solver.solve(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        solver.solveBFS(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
