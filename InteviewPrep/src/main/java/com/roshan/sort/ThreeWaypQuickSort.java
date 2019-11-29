package com.roshan.sort;

import java.util.Arrays;

public class ThreeWaypQuickSort {

	
	public static void sort(int[] arr) {
		QSortImpl(arr, 0, arr.length-1);
	}
	
	private static void QSortImpl(int[] arr, int low, int high) {

		if(low >= high) return;
		
		int lt = low , gt = high;
		int v = arr[low];
		int i  = low;
		
		while (i <= gt) {
			if(arr[i] < v) 
				swap(arr , i++ , lt++);
			else if (arr[i] == v) 
				i++;
			else 
				swap(arr , i , gt--);
		}
		
		QSortImpl(arr, low, lt - 1);
		QSortImpl(arr, gt + 1, high);

	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,7,4,2,3,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}


}
