package com.roshan.leetcode;

public class P62UniquePath {

    public int uniquePaths(int m, int n) {

        return uniquePathUtil(m-1,n-1,0,0);

    }
    private int uniquePathUtil(int targetRow, int targetCol, int row, int col) {

        if(row  ==  targetRow && col == targetCol){
            return 1;
        }

        if(row > targetRow || col > targetCol){
            return 0;
        }

        return  uniquePathUtil(targetRow, targetCol, row, col+1)
                + uniquePathUtil(targetRow, targetCol, row+1, col);


    }

    public int uniquePathsDP(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            dp[i][0] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i < m;i++){
            for(int j = 1 ; j < n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        P62UniquePath p = new P62UniquePath();
        System.out.println(p.uniquePaths(3,7));
        System.out.println(p.uniquePathsDP(3,7));
    }


}
