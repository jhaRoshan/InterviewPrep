package com.roshan.leetcode;

import java.util.Arrays;

public class P63UniquePath2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        int isObs = 0;
        for(int i = 0 ; i < m ; i++){
            if(obstacleGrid[i][0] == 1){
                isObs = 1;
            }
            dp[i][0] = (isObs != 1) ? 1:0;
        }
        isObs =0;
        for(int i = 0 ; i < n ; i++){
            if(obstacleGrid[0][i] == 1){
                isObs = 1;
            }
            dp[0][i] = (isObs != 1) ? 1:0;
        }

        for(int i = 1; i < m;i++){
            for(int j = 1 ; j < n;j++){
                dp[i][j] = (obstacleGrid[i][j] != 1) ? dp[i-1][j] + dp[i][j-1]:0;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        P63UniquePath2 p  = new P63UniquePath2();
        int[][] arr = {{0,0},{1,1},{0,0}};
        System.out.println(p.uniquePathsWithObstacles(arr));
    }
}
