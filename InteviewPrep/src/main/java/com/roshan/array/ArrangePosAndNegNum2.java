package com.roshan.array;

import java.util.Arrays;

//https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/

public class ArrangePosAndNegNum2 {

	public static void arrangeByModMergeSort(int[] arr) {
		sort(arr,0,arr.length-1);
	}
	
	public static void sort(int[] arr , int low , int high) {
		if(high <= low) return;
		int mid = low + (high-low)/2;
		sort(arr,low,mid);
		sort(arr,mid+1,high);
		merge(arr,low,mid,high);
		
	}
	
	private static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; i++) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; j++) 
            R[j] = arr[m + 1+ j]; 
  
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && L[i] < 0) 
        { 
                arr[k] = L[i]; 
                i++; 
                k++; 
        }
        
        while (j < n2 && R[j] < 0) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }
        
        while (i < n1 && L[i] >= 0) 
        { 
                arr[k] = L[i]; 
                i++; 
                k++; 
        }
  
        while (j < n2 && R[j] >= 0) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }
  
    } 


	public static void main(String[] args) {
		int[] arr = { 12, 11, -13, -5, 6, -7, 5, -3, -6 };
		arrangeByModMergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
