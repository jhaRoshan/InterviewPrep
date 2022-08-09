package com.roshan.backtracking;

import java.util.Arrays;

public class NQueen {


    public static boolean getWays(int size) {

        boolean[][] board = new boolean[size][size];

        if (getWaysUtil(board, size, 0)) {
            System.out.println(Arrays.deepToString(board));
            return true;
        }
        return false;
    }


    public static boolean getWaysUtil(boolean[][] board, int size, int col) {

        if (col == size) {
            return true;
        }

        for (int row = 0; row < size; row++) {

            if (isSafe(board, row, col, size)) {
                board[row][col] = true;
                if (getWaysUtil(board, size, col + 1)) {
                    return true;
                }
                board[row][col] = false;
            }

        }
        return false;
    }


    public static boolean isSafe(boolean[][] board, int row, int col, int size) {

        //row
        for (int i = 0; i < size; i++) {
            if (board[row][i]) {
                return false;
            }
        }

        //upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        //lower left diagonal
        for (int i = row, j = col; i <size && j >=0; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(getWays(4));
    }

}
