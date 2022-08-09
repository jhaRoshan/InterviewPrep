package com.roshan.dp.knapsack;

public class SubsetSum {

	
	public static boolean isSubsetSumRec(int set[],  int n, int sum) { 
		if(sum == 0) {
			return true;
		}
		if(n <= 0) {
			return false;
		}

		if(set[n-1] > sum){
			return isSubsetSumRec(set, n-1, sum);
		}

		return (isSubsetSumRec(set, n-1, sum) || isSubsetSumRec(set, n-1, sum-set[n-1]));
	}


	public static boolean isSubsetSumDP(int set[],  int n, int sum){

		boolean[][] dp = new boolean[n+1][sum+1];

		for(int j=0;j<=sum;j++){
			dp[0][j] = false;
		}

		for(int i=0;i<=n;i++){
			dp[i][0] = true;
		}


		for(int i = 1; i <=n;i++){
			for(int j=1;j<=sum;j++){
				if(set[i-1] > j){
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
				}
			}
		}

		return dp[n][sum];

	}



	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};

		for(int i=0;i<=20;i++){
			System.out.println("Rec:"+i);
			System.out.println(isSubsetSumRec(set, set.length, i));
			System.out.println("DP:"+i);
			System.out.println(isSubsetSumDP(set, set.length, i));
		}
	}

}
