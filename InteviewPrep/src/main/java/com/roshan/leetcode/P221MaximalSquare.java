package com.roshan.leetcode;

public class P221MaximalSquare {

    public int maximalSquare(char[][] matrix) {


        int[][] dp = new int[matrix.length][matrix[0].length];

        int count = 0;

        for(int i = 0 ; i < matrix.length;i++){
            dp[i][0] = matrix[i][0]-'0';
            count = Math.max(dp[i][0] , count );
        }

        for(int i = 0 ; i < matrix[0].length;i++){
            dp[0][i] = matrix[0][i]-'0';
            count = Math.max(dp[0][i] , count );
        }



        for(int i = 1; i< matrix.length ; i++){
            for(int j = 1 ; j< matrix[0].length;j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = min(dp[i-1][j] , dp[i][j-1] , dp[i-1][j-1]) +1;
                    count = Math.max(dp[i][j] , count );
                }
            }
        }
        return count*count;

    }

    private int min(int x,int y , int z){
        return Math.min(Math.min(x,y),z);
    }

    public static void main(String[] args) {
        P221MaximalSquare p = new P221MaximalSquare();
        char[][] arr= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(p.maximalSquare(arr));

    }
}
