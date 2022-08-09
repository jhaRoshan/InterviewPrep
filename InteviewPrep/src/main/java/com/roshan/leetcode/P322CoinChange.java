package com.roshan.leetcode;

import java.util.Arrays;

public class P322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= amount; i++)
            dp[0][i] = Integer.MAX_VALUE - 2;

        for (int i = 0; i <= coins.length; i++)
            dp[i][0] = 0;


        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1+ dp[i][j - coins[i - 1]]);
                }

            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[coins.length][amount] == Integer.MAX_VALUE -2 ? -1: dp[coins.length][amount] ;
    }

    public static void main(String[] args) {
        P322CoinChange p = new P322CoinChange();
        int[] arr = {1, 2, 5};
        System.out.println(p.coinChange(arr, 11));
    }

}
