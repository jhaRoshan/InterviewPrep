package com.roshan.backtracking;

import java.util.Arrays;

public class PrintAllSudoku {

    public static void printSudoku(int[][] board){
        printSudokuUtil(board,0,0);
    }


    public static boolean printSudokuUtil(int[][] board , int row  , int col){

        if(row ==8 && col ==9){
            System.out.println(Arrays.deepToString(board));
            return true;
        }


        if(col == 9){
            row = row+1;
            col =0;
        }

        if(board[row][col] != 0){
            return printSudokuUtil(board, row, col+1);
        }else {
            for (int i = 1; i < 10; i++) {
                if (Sudoku.isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if (printSudokuUtil(board, row, col + 1)) {
//                        return true;
                    }
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        printSudoku(grid);
    }
}
