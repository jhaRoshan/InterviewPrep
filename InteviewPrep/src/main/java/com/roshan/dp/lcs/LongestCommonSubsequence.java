package com.roshan.dp.lcs;

public class LongestCommonSubsequence {

	
	public static int getLCSRec(char[] arr1, char[] arr2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}

		if (arr1[m - 1] == arr2[n - 1]) {
			return 1 + getLCSRec(arr1, arr2, m - 1, n - 1);
		}

		return Math.max(getLCSRec(arr1, arr2, m - 1, n), getLCSRec(arr1, arr2, m, n - 1));
	}
	
	
	public static int getLCSDP(char[] arr1, char[] arr2, int m, int n) {
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 1;i <= m; i++) {
			for(int j = 1 ; j <=n;j++) {
				if(arr1[i-1] == arr2[j-1]) {
					dp[i][j] = 1+ dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + getLCSRec(X, Y, m, n));
		System.out.println("Length of LCS is" + " " + getLCSDP(X, Y, m, n));
	}

}
