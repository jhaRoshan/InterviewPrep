package com.roshan.leetcode;

import com.roshan.segmenttree.MinSegTree;
import org.apache.commons.math3.util.MathUtils;

public class P84LargestRectInHistogram {


    public int largestRectangleArea(int[] heights) {
        MinSegTree segTree = new MinSegTree();
        segTree.construct(heights);
        return largestRectangeUtil(segTree , 0 , heights.length-1 , heights);
    }

    private int largestRectangeUtil(MinSegTree segTree, int start, int end, int[] heights) {

        if(end < start) return Integer.MIN_VALUE;

        if(start == end){
            return heights[start];
        }

        int minIndex = segTree.findMin(start , end);

        return max(  largestRectangeUtil(segTree , start , minIndex-1 , heights),
                largestRectangeUtil(segTree , minIndex+1 , end , heights) ,
                ((end-start)+1)*heights[minIndex]
                );
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a,b),c);
    }

    public static void main(String[] args) {
        P84LargestRectInHistogram h = new P84LargestRectInHistogram();
        int[] a = {2,1,5,6,2,3};
        System.out.println(h.largestRectangleArea(a));

    }
}
