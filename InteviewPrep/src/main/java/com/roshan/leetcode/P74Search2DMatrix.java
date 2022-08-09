package com.roshan.leetcode;

public class P74Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int start = 0, end = rowLen-1;

        int targetRow = -1;

        while(start <= end){
            int mid = start+ (end-start)/2;
            if(matrix[mid][0] <= target && matrix[mid][colLen-1] >= target){
                targetRow = mid;
                break;
            }

            else if(matrix[mid][0] < target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }

        }

        if(targetRow == -1) return false;

        start = 0 ; end = colLen-1;
        while(start <= end){
            int mid = start+ (end-start)/2;
            if(matrix[targetRow][mid] == target){
                return true;
            }

            else if(matrix[targetRow][mid] < target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr,3));

    }
}
