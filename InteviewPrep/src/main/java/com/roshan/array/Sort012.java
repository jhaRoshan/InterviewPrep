package com.roshan.array;

import java.util.Arrays;

public class Sort012 {

	
	public static void sort(int[] arr, int low, int high) {
		int lt = low , gt = high;
		int v = 1;
		int i  = low;
		
		while (i <= gt) {
			if(arr[i] < v) 
				swap(arr , i++ , lt++);
			else if (arr[i] == v) 
				i++;
			else 
				swap(arr , i , gt--);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,2,1,0,0,2,2,1,0};
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}

}
