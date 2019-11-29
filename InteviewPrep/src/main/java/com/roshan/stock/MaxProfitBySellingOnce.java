package com.roshan.stock;

public class MaxProfitBySellingOnce {

	
	public static int getMax(int[] arr) {
		
		int min = arr[0];
		int maxDiff = arr[1] - arr[0];
		
		for(int i = 1 ; i < arr.length ;i++ ) {
			if((arr[i] - min) > maxDiff) {
				maxDiff = arr[i] - min;
			}
			
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		return maxDiff;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 90, 10, 110}; 
		System.out.println(getMax(arr));
	}

}
