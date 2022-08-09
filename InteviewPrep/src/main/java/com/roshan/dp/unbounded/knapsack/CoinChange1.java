package com.roshan.dp.unbounded.knapsack;


import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange1 {


    public static int getNumOfWaysRec(int[] arr , int N){
        return getNumOfWaysRecUtil(arr,N,arr.length);
    }

    private static int getNumOfWaysRecUtil(int[] arr , int N , int len){

        if(N == 0) return 1;
        if(len == 0) return 0;
        if(N < 0) return 0;

        if(arr[len-1] > N){
            return getNumOfWaysRecUtil(arr, N, len-1);
        }else{
            return getNumOfWaysRecUtil(arr, N-arr[len-1], len) +
                    getNumOfWaysRecUtil(arr, N, len-1);
        }

    }

    private static int getNumOfWaysRecDP(int[] arr , int N){


        int [][] dp = new int[arr.length+1][N+1];

        for(int i = 0;i <=N ;i++){
            dp[0][i] = 0;
        }

        for(int j = 0;j <=arr.length ;j++){
            dp[j][0] = 1;
        }

        for(int i = 1; i <=  arr.length;i++){
            for(int j = 1 ;j <= N ; j++ ){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-arr[i-1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[arr.length][N];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int N = 5;
        System.out.println(getNumOfWaysRec(arr,N));
        System.out.println(getNumOfWaysRecDP(arr,N));
    }

}
