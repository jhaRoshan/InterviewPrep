package com.roshan.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class P295MedianFinder {

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    
    
    
    public P295MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        
        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        
        
    }
    
    public double findMedian() {
        int diff = maxHeap.size() - minHeap.size();
		if(diff == 0) {
			return (maxHeap.peek() + minHeap.peek())/(float)2;
		}
        return maxHeap.peek();
    }
}

/**
 * Your P295MedianFinder object will be instantiated and called as such:
 * P295MedianFinder obj = new P295MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */