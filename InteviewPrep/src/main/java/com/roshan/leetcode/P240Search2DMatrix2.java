package com.roshan.leetcode;

public class P240Search2DMatrix2 {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowLen = matrix.length;
        int colLength = matrix[0].length;
        int row = 0 , col = colLength-1;
        while(row < rowLen && col >= 0 ){
            if(matrix[row][col] == target){
                return true;
            }

            else if(matrix[row][col] > target){
                col--;
            }

            else if(matrix[row][col] < target){
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] arr = {
                    {1,4,7,11,15},
                    {2,5,8,12,19},
                    {3,6,9,16,22},
                    {10,13,14,17,24},
                    {18,21,23,26,30}
                    };
        System.out.println(searchMatrix(arr,5));


         int[][] arr1 = new int[1][1];
         arr1[0][0] = -5;

        System.out.println(searchMatrix(arr1,-5));
    }
}
