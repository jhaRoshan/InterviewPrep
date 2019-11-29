package com.roshan.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<K extends Comparable<K>>  implements Heap<K> {

	private List<K> heap = new ArrayList<>();
	
	public void insert(K val) {
		heap.add(val);
		heapifyUp(heap.size() - 1);
	}
	
	public K remove() {
		K val = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size()-1);
		heapifyDown(0);
		return val;
	}
	
	public K get() {
		K val = heap.get(0);
		return val;
	}

	private void heapifyUp(int i) {
		int parentIndex = getParentIndex(i);
		if(isValidIndex(parentIndex) && compareValue(i,parentIndex) < 1) {
			swap(i , parentIndex);
			heapifyUp(parentIndex);
		}
	}

	private int compareValue(int i, int j) {
		return heap.get(i).compareTo(heap.get(j));
	}

	private void swap(int i, int j) {
		K temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j,temp);
	}

	private void heapifyDown(int i) {
		int leftChildIndex = getLeftChildIndex(i);
		int rightChildIndex = getRightChildIndex(i); 
		int lowestChildValueIndex = getLowestChildValueIndex(leftChildIndex , rightChildIndex);
		
		if(lowestChildValueIndex != -1 && heap.get(i).compareTo(heap.get(lowestChildValueIndex)) > 0) {
			swap(i, lowestChildValueIndex);
			heapifyDown(lowestChildValueIndex);
		}
	}
	

	private int getLowestChildValueIndex(int leftChildIndex, int rightChildIndex) {
		boolean isValid1 = isValidIndex(leftChildIndex);
		boolean isValid2 = isValidIndex(rightChildIndex);
		
		if(!isValid1 && !isValid2) {
			return -1;
		}else if(!isValid2) {
			return leftChildIndex;
		}else if(!isValid1) {
			return rightChildIndex;
		}else {
			return heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) > 0 ?leftChildIndex:rightChildIndex; 
		}
	}

	private boolean isValidIndex(int leftChildIndex) {
		return leftChildIndex >=0 && leftChildIndex < heap.size();
	}

	private int getLeftChildIndex(int i) {
		return 2*i + 1;
	}
	
	private int getRightChildIndex(int i) {
		return 2*i + 2;
	}

	private int getParentIndex(int i) {
		return i ==0 ? -1 : (i-1)/2;
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< heap.size()/2 ;i++) {
			if(isValidIndex(i)) {
				sb.append("Parent:").append(heap.get(i));
			}
			if(isValidIndex(getLeftChildIndex(i))) {
				sb.append(" Left Child:").append(heap.get(getLeftChildIndex(i)));
			}
			if(isValidIndex(getRightChildIndex(i))){
				sb.append(" Right Child:").append(heap.get(getRightChildIndex(i)));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public int getSize() {
		return heap.size();
	}

}