package com.roshan.dp.knapsack;

public class MinSubsetDiff {

    public static int getMinSubSetDiffRec(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        return getMinSubSetDiffRecUtil(arr, sum, 0, arr.length);
    }

    public static int getMinSubSetDiffRecUtil(int[] arr, int sum, int currSum, int n) {

        if (n == 0) {
            int otherSetSum = sum - currSum;
            return Math.abs(otherSetSum - currSum);
        }

        return Math.min(
                getMinSubSetDiffRecUtil(arr, sum, currSum, n - 1),
                getMinSubSetDiffRecUtil(arr, sum, currSum + arr[n - 1], n - 1)
        );
    }



    public static int getMinSubSetDiffDP(int[] arr) {

        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        boolean [][] dp = new boolean[arr.length+1][sum+1];

        for(int j=0;j<=sum;j++){
            dp[0][j] = false;
        }

        for(int i=0;i<=arr.length;i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i<= sum/2;i++){
            if(dp[arr.length][i]){
                int currDiff = sum - 2*i;
                minDiff = Math.min(minDiff,currDiff);
            }
        }

        return minDiff;

    }


    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 2, 1 };
        System.out.println(getMinSubSetDiffRec(arr));
        System.out.println(getMinSubSetDiffDP(arr));


    }
}
