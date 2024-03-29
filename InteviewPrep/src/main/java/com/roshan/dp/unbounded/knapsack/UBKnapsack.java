package com.roshan.dp.unbounded.knapsack;

import java.util.Arrays;

public class UBKnapsack {

    public static int getMaxValRec(int[] val, int[] wt, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] > w) {
            return getMaxValRec(val, wt, w, n - 1);
        } else {
            return Math.max(val[n - 1] + getMaxValRec(val, wt, w - wt[n - 1], n), getMaxValRec(val, wt, w, n - 1));
        }
    }

    public static int getMaxValDP(int[] val, int[] wt, int W, int n) {

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i][w - wt[i - 1]]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[n][W];
    }

    public static void main(String[] args) {
        int W = 100;
        int val[]  = {1, 30};
        int wt[] = {1, 50};
        int n = val.length;

        System.out.println(getMaxValRec(val, wt, W, n));

        System.out.println(getMaxValDP(val, wt, W, n));
    }
}
