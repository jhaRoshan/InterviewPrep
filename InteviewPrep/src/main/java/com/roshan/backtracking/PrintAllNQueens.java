package com.roshan.backtracking;

import com.roshan.test.Test;

import java.util.Arrays;

public class PrintAllNQueens {

    public static boolean getWays(int size) {

        boolean[][] board = new boolean[size][size];
        return getWaysUtil(board, size, 0);
    }


    public static boolean getWaysUtil(boolean[][] board, int size, int col) {

        if (col == size) {
            System.out.println(Arrays.deepToString(board));
            return true;
        }

        for (int row = 0; row < size; row++) {

            if (NQueen.isSafe(board, row, col, size)) {
                board[row][col] = true;
                getWaysUtil(board, size, col + 1);
                board[row][col] = false;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getWays(4));
    }
}
