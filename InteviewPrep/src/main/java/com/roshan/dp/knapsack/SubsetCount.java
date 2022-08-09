package com.roshan.dp.knapsack;

//number of subset with given sum
public class SubsetCount {

	
	public static int findSubsetCount(int set[],  int n, int sum) {
		if(sum == 0) {
			return 1;
		}
		if(n <= 0) {
			return 0;
		}

		if(set[n-1] > sum){
			return findSubsetCount(set, n-1, sum);
		}

		return (findSubsetCount(set, n-1, sum) + findSubsetCount(set, n-1, sum-set[n-1]));
	}


	public static int findSubsetCountDP(int arr[],  int n, int sum) {

		int [][] dp = new int[arr.length+1][sum+1];

		for(int j=0;j<=sum;j++){
			dp[0][j] = 0;
		}

		for(int i=0;i<=arr.length;i++){
			dp[i][0] = 1;
		}

		for(int i = 1; i <=arr.length;i++){
			for(int j=1;j<=sum;j++){
				if(arr[i-1] > j){
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		return dp[arr.length][sum];
	}



	public static void main(String[] args) {
		int set[] = {1, 2, 3, 3};
		int sum = 6;
		System.out.println(findSubsetCount(set, set.length, sum));
		System.out.println(findSubsetCountDP(set, set.length, sum));


	}

}
