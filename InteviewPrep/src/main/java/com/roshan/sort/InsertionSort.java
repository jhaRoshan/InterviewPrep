package com.roshan.sort;

import java.util.Arrays;

public class InsertionSort {

	public void sort(int arr[]) {
		for(int i = 1;i<arr.length;i++) {
			for (int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					swap(arr, j, j-1);
				}
				else break;
			}
		}
	}
	
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,7,4,2,3,1};
		InsertionSort is = new InsertionSort();
		is.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
