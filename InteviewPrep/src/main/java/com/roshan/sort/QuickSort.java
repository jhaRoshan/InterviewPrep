package com.roshan.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public void QSort(int[] arr) {
		suffle(arr);
		QSortImpl(arr, 0, arr.length-1);
	}

	public void QSortImpl(int[] arr, int low, int high) {
            
		    if(high < low ) 
		    	return;
		    int p = partion(arr , low , high);
			QSortImpl(arr, low, p-1);
			QSortImpl(arr, p+1, high);
	}

	public int partion(int[] arr , int low , int high) {
		
		int i = low , j = high;
		
		while(true) {
			while(arr[i] < arr[low] && i < high) i++;
			while(arr[j] > arr[low] && j > 0) j--;
			
			if(i >=j) break;
			
			swap(arr, i, j);
		}
		swap(arr, low, j);
		return j;
	}
	
	

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void suffle(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int r = new Random().nextInt(i);
			swap(arr, i, r);
		}

	}

	public static void main(String[] args) {
		int c = 8000;
		
		int[] arr =  new int[c];
		for(int i=0;i<c;i++) arr[i] = i;
		new QuickSort().QSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
