package org.leetcode.examples.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, solutions, n);
        return solutions;
    }

    private void backtrack(int row, char[][] board, List<List<String>> solutions, int n) {
        // Base case: if all queens are placed, add the board configuration to the result
        if (row == n) {
            solutions.add(constructBoard(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                // Place the queen
                board[row][col] = 'Q';

                // Move to the next row
                backtrack(row + 1, board, solutions, n);

                // Backtrack: remove the queen
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // Check the column for a queen
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> constructBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        BackTrackNQueens solver = new BackTrackNQueens();

        int n = 4;
        List<List<String>> solutions = solver.solveNQueens(n);
        System.out.println("Number of solutions: " + solutions.size());

        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

}
