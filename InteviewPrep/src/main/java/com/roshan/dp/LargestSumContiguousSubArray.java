package com.roshan.dp;

public class LargestSumContiguousSubArray {

	public static int getLargestSunm(int[] arr) {
		int maxEndingHere = arr[0];
		int maxSoFar = arr[0];
		for(int i = 1 ; i < arr.length ; i++) {
			maxEndingHere = Math.max(maxEndingHere+arr[i], arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	
	
	
	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		System.out.println(getLargestSunm(a));

	}

}
