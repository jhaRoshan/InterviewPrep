package com.roshan.leetcode;

import java.util.Arrays;

public class P1239SortMatrixDiagonal {

    public int[][] diagonalSort(int[][] mat) {

        int rowLen = mat.length;
        int colLen = mat[0].length;

        for(int i = 0 ; i < rowLen-1 ; i++){
            for(int j = i+1 ; j < colLen;j++){

                int top = mat[i][j-1];
                int bot = mat[i+1][j];

                if(top > bot){
                    mat[i+1][j] = top;
                    mat[i][j-1] = bot;
                }

                System.out.println(Arrays.deepToString(mat));
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        P1239SortMatrixDiagonal p = new P1239SortMatrixDiagonal();
        int[][] arr = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        p.diagonalSort(arr);
    }
}
