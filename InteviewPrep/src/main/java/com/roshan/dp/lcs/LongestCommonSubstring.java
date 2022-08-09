package com.roshan.dp.lcs;

public class LongestCommonSubstring {


	public static int getLCSRecTest(char[] arr1, char[] arr2, int m, int n , int count) {

		if (m == 0 || n == 0) {
			return count;
		}


		int max1 = Integer.MIN_VALUE;

		if (arr1[m - 1] == arr2[n - 1]) {
			max1 = getLCSRec(arr1, arr2, m - 1, n - 1, count+1);
		}
		int max2 = getLCSRec(arr1, arr2, m - 1, n, 0);
		int max3 = getLCSRec(arr1, arr2, m, n - 1 , 0);

		return Math.max(max1 ,Math.max(max2 ,max3));
	}


	public static int getLCSRec(char[] arr1, char[] arr2, int m, int n , int count) {

		if (m == 0 || n == 0) {
			return count;
		}
		if (arr1[m - 1] == arr2[n - 1]) {
			count = getLCSRec(arr1, arr2, m - 1, n - 1, count+1);
		}

		int max2 = getLCSRec(arr1, arr2, m - 1, n, 0);
		int max3 = getLCSRec(arr1, arr2, m, n - 1 , 0);

		return Math.max(count ,Math.max(max2 ,max3));
	}
	
	
	public static int getLCSDP(char[] arr1, char[] arr2, int m, int n) {
		
		int[][] dp = new int[m+1][n+1];
		int max = 0;
		
		for(int i = 1;i <= m; i++) {
			for(int j = 1 ; j <=n;j++) {
				if(arr1[i-1] == arr2[j-1]) {
					dp[i][j] = 1+ dp[i-1][j-1];
					max = Math.max(max,dp[i][j]);
				}else {
					dp[i][j] = 0;
				}
			}
		}
		return max;

	}

	public static void main(String[] args) {

		String s1 = "ONMPSNM";
		String s2 = "ONPRONM";


		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + getLCSRecTest(X, Y, m, n ,0));
		System.out.println("Length of LCS is" + " " + getLCSRec(X, Y, m, n ,0));
		System.out.println("Length of LCS is" + " " + getLCSDP(X, Y, m, n));

		s1="OldSite:GeeksforGeeks.org";
		s2="NewSite:GeeksQuiz.com";
		X = s1.toCharArray();
		Y = s2.toCharArray();
		System.out.println("Length of LCS new is" + " " + getLCSDP(X, Y, X.length, Y.length));

		System.out.println("Length of LCS is" + " " + getLCSRecTest(X, Y, X.length, Y.length ,0));
		System.out.println("Length of LCS is" + " " + getLCSRec(X, Y, X.length, Y.length,0));

	}

}
