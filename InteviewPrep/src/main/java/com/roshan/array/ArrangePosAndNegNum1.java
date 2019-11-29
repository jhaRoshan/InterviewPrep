package com.roshan.array;

import java.util.Arrays;

//https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/

public class ArrangePosAndNegNum1 {

	public static void arrangeByModInsertionSort(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			if (arr[i] > 0) {
				continue;
			} else {
				int val = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] > 0) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = val;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 12, 11, -13, -5, 6, -7, 5, -3, -6 };
		arrangeByModInsertionSort(arr);
	}

}
