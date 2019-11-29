package com.roshan.array;

import java.util.Arrays;

public class RotateArray {

	
	private static void rotate(int[] arr, int k) {
		
		reverse(arr , 0 , k-1);
		reverse(arr , k , arr.length-1);
		reverse(arr , 0 , arr.length-1);
	}
	
	private static void reverse(int[] arr, int low, int high) {
		if(high<=low) {
			return;
		}
		swap(arr,low,high);
		reverse(arr, low+1, high-1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5}; 
		rotate(arr , 2);
		System.out.println(Arrays.toString(arr));
	}



}
