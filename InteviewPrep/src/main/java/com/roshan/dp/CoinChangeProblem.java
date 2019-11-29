package com.roshan.dp;

public class CoinChangeProblem {

	
	public static int getWaysRec(int[] coin , int val , int index) {
		if(val == 0 && index >=0) {
			return 1;
		}
		
		if(val < 0 || (val > 0 && index <0)) {
			return 0;
		}
		
		if(index < 0) {
			return 0;
		}
		
		
		return getWaysRec(coin , val , index-1) + 
				getWaysRec(coin , val - coin[index] , index);
	}
	
	
	public static int getWaysDP(int[] coin , int val) {
		
		int[] dp = new int[val+1];
		dp[0] = 1;
		
		for(int i = 0;i < coin.length ; i++) {
			for(int j = coin[i] ; j <= val ; j++) {
				dp[j] += dp[j - coin[i]]; 
			}
		}
		return dp[val];
		
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1, 2}; 

//		System.out.println( getWaysRec(arr, 4, 2)); 
        
        System.out.println( getWaysDP(arr, 4)); 

	}

}
