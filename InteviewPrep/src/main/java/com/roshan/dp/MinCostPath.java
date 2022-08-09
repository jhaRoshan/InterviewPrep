package com.roshan.dp;

import java.util.Arrays;

public class MinCostPath {


    public int findMinCostRec(int arr[][]) {
        return findMinCostRecUtil(arr, 0, 0, arr.length, arr[0].length);
    }


    public int findMinCostDP(int arr[][]) {
        int rowLen = arr.length;
        int colLen = arr[0].length;

        int dp[][] = new int[rowLen][colLen];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < rowLen; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        for (int j = 1; j < colLen; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }


        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                dp[i][j] = arr[i][j] + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[rowLen - 1][colLen - 1];


    }

    private int findMinCostRecUtil(int[][] arr, int row, int col, int rowLen, int colLen) {

        if (row == rowLen - 1 && col == colLen - 1) {
            return arr[row][col];
        }

        if (row >= rowLen || col >= colLen) {
            return Integer.MAX_VALUE;
        }

        return arr[row][col] + min(
                findMinCostRecUtil(arr, row + 1, col, rowLen, colLen),
                findMinCostRecUtil(arr, row, col + 1, rowLen, colLen),
                findMinCostRecUtil(arr, row + 1, col + 1, rowLen, colLen)
        );


    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }


    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        MinCostPath mp = new MinCostPath();
        System.out.println(mp.findMinCostRec(cost));
        System.out.println(mp.findMinCostDP(cost));
    }

}
