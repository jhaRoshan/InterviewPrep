package com.roshan.array;

import java.util.Arrays;

public class MoveAllZeroToEnd {

	public static void moveZerotoEnd(int[] arr) {
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				arr[count] = arr[i];
				count++;
			}
		}
		
		
		for (int i = count; i < arr.length; i++) {
			arr[i] = 0;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void main(String[] args) {
		 int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}; 
		 moveZerotoEnd(arr);
	}

}
