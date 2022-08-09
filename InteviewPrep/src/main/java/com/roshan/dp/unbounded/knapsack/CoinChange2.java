package com.roshan.dp.unbounded.knapsack;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange2 {

    public static int getNumOfWaysRec(int[] arr , int N){
        int n = getNumOfWaysRecUtil(arr,N,arr.length , 0);
        return n == Integer.MAX_VALUE?-1:n;
    }

    private static int getNumOfWaysRecUtil(int[] arr , int N , int len , int coinsNum){

        if(N == 0) return coinsNum;
        if(len == 0) return Integer.MAX_VALUE;
        if(N < 0) return Integer.MAX_VALUE;

        if(arr[len-1] > N){
            return getNumOfWaysRecUtil(arr, N, len-1 , coinsNum);
        }else{

            return Math.min(getNumOfWaysRecUtil(arr, N-arr[len-1], len , coinsNum+1) ,
                    getNumOfWaysRecUtil(arr, N, len-1 , coinsNum));
        }

    }


    private static int getNumOfWaysDP(int[] arr , int N){

        int[][] dp = new int[arr.length+1][N+1];

        for(int i = 0;i <=N ;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }

        for(int j = 0;j <=arr.length ;j++){
            dp[j][0] = 0;
        }

        for(int i = 1; i <=  arr.length;i++){
            for(int j = 1 ;j <= N ; j++ ){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else if(dp[i][j-arr[i-1]] == Integer.MAX_VALUE){ //just to handle overflow as 1 + MAXVALUE = -(MAXVALUE+1)
                    dp[i][j] = Math.min(dp[i-1][j] , Integer.MAX_VALUE);//dp[i][j] = Math.min(dp[i-1][j] , 1+ dp[i][j-arr[i-1]]);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] , 1+ dp[i][j-arr[i-1]]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[arr.length][N];

    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(getNumOfWaysRec(coins , amount));
        System.out.println(getNumOfWaysDP(coins , amount));
        System.out.println("------------------");

        coins = new int[]{2};
        System.out.println(getNumOfWaysRec(coins , 1));
        System.out.println(getNumOfWaysDP(coins , 1));
        System.out.println("------------------");

        coins = new int[]{2};
        System.out.println(getNumOfWaysRec(coins , 0));
        System.out.println(getNumOfWaysDP(coins , 0));

        System.out.println("------------------");

        coins = new int[]{1,5,2};
        System.out.println(getNumOfWaysRec(coins , 5));
        System.out.println(getNumOfWaysDP(coins , 5));

        System.out.println("------------------");

        coins = new int[]{5,2,1};
       ; System.out.println(getNumOfWaysRec(coins , 5));
        System.out.println(getNumOfWaysDP(coins , 5));

        System.out.println("------------------");

        coins = new int[]{3,5,2};
        System.out.println(getNumOfWaysRec(coins , 5));
        System.out.println(getNumOfWaysDP(coins , 5));


    }
}
