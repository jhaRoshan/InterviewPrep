package com.roshan.dp;

public class SubsetSum {

	
	public static boolean isSubsetSumRec(int set[],  int n, int sum) { 
	
		if(sum == 0) {
			return true;
		}
		
		if(sum != 0 && n <= 0) {
			return false;
		}

		return (isSubsetSumRec(set, n-1, sum) || isSubsetSumRec(set, n-1, sum-set[n-1]));
	}

	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2}; 
        System.out.println(isSubsetSumRec(set, set.length, 9));
        System.out.println(isSubsetSumRec(set, set.length, 10));
	}

}
