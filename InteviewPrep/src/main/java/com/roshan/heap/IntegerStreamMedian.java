package com.roshan.heap;



public class IntegerStreamMedian {

	private MaxHeap<Integer> maxHeap = new MaxHeap<>();
	private MinHeap<Integer> minHeap = new MinHeap<>();
	
	public void insert(Integer val) {
		if(maxHeap.getSize() == 0) {
			maxHeap.insert(val);
		}else if(maxHeap.get() > val) {
			maxHeap.insert(val);
		}else {
			minHeap.insert(val);
		}
		
		int diff = maxHeap.getSize() - minHeap.getSize();
		
		if(diff > 1) {
			int maxVal = maxHeap.remove();
			minHeap.insert(maxVal);
		}else if(diff < -1) {
			int minVal = minHeap.remove();
			maxHeap.insert(minVal);
		}
	}
	
	public float getMedian() {
		int diff = maxHeap.getSize() - minHeap.getSize();
		if(diff == 0) {
			return (maxHeap.get() + minHeap.get())/(float)2;
		}else if(diff > 0) {
			return maxHeap.get();
		}else {
			return minHeap.get();
		}
		
	}
	
	public static void main(String[] args) {
		IntegerStreamMedian ism = new IntegerStreamMedian();
		ism.insert(2);
		System.out.println(ism.getMedian());
		ism.insert(3);
		System.out.println(ism.getMedian());
		ism.insert(4);
		System.out.println(ism.getMedian());
		
		ism.insert(1);
		System.out.println(ism.getMedian());
		
		
	}
	
	
	
	
}