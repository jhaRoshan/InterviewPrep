package com.roshan.stock;

import java.util.Arrays;

public class MaxProfitWithKTransaction {

	
	public static int getMaxprofit(int[] price  , int k) {
		
		int[][] matrix = new int[k+1][price.length];
		
		int n = price.length;
		//with 0 transaction
		
		for (int i = 0; i < n; i++) {
			matrix[0][i] = 0 ; 
		}
		
		//buying/selling on same day
		for (int i = 0; i <= k; i++) {
			matrix[i][0] = 0 ; 
		}
		
		
		for (int t = 1; t <= k; t++) {
			int maxSoFar = Integer.MIN_VALUE;
			for (int d = 1; d < n; d++) {
				maxSoFar = Math.max(maxSoFar, matrix[t-1][d-1] - price[d-1]);
				matrix[t][d] = Math.max(matrix[t][d-1], maxSoFar + price[d]);
			}
		}
		System.out.println(Arrays.deepToString(matrix));
		return matrix[k][price.length-1];
	}
	
	
	public static void main(String[] args) {
		int[] prices = {2,5,7,1,4,3,1,3};
		System.out.println(getMaxprofit(prices, 3));

	}

}
