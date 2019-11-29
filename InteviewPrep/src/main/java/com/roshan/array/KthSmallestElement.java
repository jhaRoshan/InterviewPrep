package com.roshan.array;

import com.roshan.heap.MaxHeap;

public class KthSmallestElement {

	public static int kthSmallest(int[] arr , int k) {
		
		MaxHeap<Integer> mh = new MaxHeap<>();
		for (int i = 0; i < k; i++) {
			mh.insert(arr[i]);
		}
		
		for(int i=k;i<arr.length;i++) {
			if(mh.get() > arr[i]) {
				mh.remove();
				mh.insert(arr[i]);
			}
		}
		
		return mh.get();
	}
	
	public static void main(String[] args) {
		int  arr[] = {7, 10, 4, 3, 20, 15};
		System.out.println(kthSmallest(arr, 3));
		System.out.println(kthSmallest(arr, 4));
	}

}
