package com.roshan.sort;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] arr) {
		int[] auxArr = new int[arr.length];
		sort(arr,0,arr.length-1 , auxArr);
	}
	
	
	public static void sort(int[] arr , int low , int high, int[] auxArr) {
		if(high <= low) return;
		int mid = low + (high-low)/2;
		sort(arr,low,mid,auxArr);
		sort(arr,mid+1,high,auxArr);
		merge(arr,low,mid,high,auxArr);
		
	}
	
	
	private static void merge(int arr[], int low, int mid, int high, int[] aux) 
	{

		for (int i = low; i <= high; i++) {
			aux[i] = arr[i];
		}

		// Initial indexes of first and second subarrays
		int i = low, j = mid + 1;

		for (int k = low; k <= high; k++) {

			if (i > mid)
				arr[k] = aux[j++];
			else if (j > high)
				arr[k] = aux[i++];
			else if (aux[j] < aux[i])
				arr[k] = aux[j++];
			else
				arr[k] = aux[i++];

		}

	} 
  


	public static void main(String[] args) {
		int[] arr =  {38, 27, 43, 3, 9, 82, 10};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
