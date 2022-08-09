package com.roshan.backtracking;

import java.util.Arrays;

public class Sudoku {

    public static void printSudoku(int[][] board){
        printSudokuUtil(board,0,0);
        System.out.println(Arrays.deepToString(board));
    }


    public static boolean printSudokuUtil(int[][] board , int row  , int col){

        if(row ==8 && col ==9){
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
                if (isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if (printSudokuUtil(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }


    static boolean isValid(int[][] board, int row, int col, int num){

        for(int i = 0 ; i < 9;i++){
            if(board[row][i] == num){
                return false;
            }
        }

        for(int i = 0 ; i < 9;i++){
            if(board[i][col] == num){
                return false;
            }
        }

        //3x3 grid
        int startRow = 3*(row/3);
        int startCol = 3*(col/3);

        for(int i = startRow ; i < startRow+3;i++){
            for(int j = startCol ; j < startCol+3 ; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
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
