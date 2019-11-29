package com.roshan.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestBitonicSubsequence {

	
	public int longestSubsequenceLength(int[] arr) {
		//int[] arr = A.stream().mapToInt(val -> val).toArray();
		
		//store from left to right
		int[] lis = new int[arr.length];
		Arrays.fill(lis, 1);
		
		//store from right to left
		int[] lds = new int[arr.length]; 
		Arrays.fill(lds, 1);
		
		
		//find lis
		for(int i = 0; i < arr.length ;i++) {
			for(int j = 0;j<i;j++) {
				if(arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i] , lis[j] +1);
				}
			}
		}
		
		System.out.println(Arrays.toString(lis));
		//find lds
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr.length-1; j > i; j--) {
				if (arr[i] > arr[j]) {
					lds[i] = Math.max(lds[i], lds[j] + 1);
				}
			}
		}
		System.out.println(Arrays.toString(lds));
		
		int currMax = 0;
		for(int i = 0; i < arr.length  ;i++) {
			currMax = Math.max(currMax , lis[i]+lds[i] - 1);
		}
		
		return currMax;
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = { 80, 60, 30, 40, 20, 10 };
		
		LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
		
		System.out.println(lbs.longestSubsequenceLength(arr));
		
	}

}
