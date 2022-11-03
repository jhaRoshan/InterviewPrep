package com.roshan.inter.prep;

import java.util.*;

public class MergeTwoSortedArray {

	
	public static void mergeTwoSortedArray(int arr1[] , int arr2[]) {


		int arr1Len = arr1.length;
		int arr2Len = arr2.length;
		
		for (int i = arr2Len - 1; i >= 0; i--) {
			int item = arr2[i];
			
			int arr1Last = arr1[arr1Len-1];
			
			int j = arr1Len-2;
			
			for (; j >= 0 && arr1[j] > item; j--) {
				arr1[j + 1] = arr1[j];
			}
			
			if (j != arr1Len - 2 || arr1Last > item) {
				arr1[j+1] = arr2[i];
				arr2[i] = arr1Last;
			}	
			
		}
		
	}
	
	
	public static void main(String[] args) {
		int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
	    int arr2[] = new int[]{2, 3, 8, 13};

	    mergeTwoSortedArray(arr1, arr2);

	    System.out.println(Arrays.toString(arr1));
	    System.out.println(Arrays.toString(arr2));







	}

}
