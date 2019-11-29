package com.roshan.sort;

import java.util.Arrays;

public class IterativeMergeSort {

	public static void mergeSort(int[] arr) {
		int n = arr.length;
		int[] aux = new int[n];

		for (int curr_size = 1; curr_size <= n - 1; curr_size = 2 * curr_size) {

			for (int left_start = 0; left_start < n - 1; left_start += 2 * curr_size) {
				int mid = left_start + curr_size - 1;
				int right_end = Math.min(left_start + 2 * curr_size - 1, n - 1);
				merge(arr, left_start, mid, right_end, aux);
			}
		}
	}

	private static void merge(int arr[], int low, int mid, int high, int[] aux) {

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
		int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
