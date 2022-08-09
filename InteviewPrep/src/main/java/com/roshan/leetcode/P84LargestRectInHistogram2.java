package com.roshan.leetcode;

import com.roshan.segmenttree.MinSegTree;

import java.util.Stack;

public class P84LargestRectInHistogram2 {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int i = 0 ; i< heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int popped = stack.pop();
                int breadth = 0;
                if(stack.isEmpty()){
                    breadth = i;
                }else{
                    breadth = i - (stack.peek()+1);
                }
                result = Math.max(result , heights[popped]*breadth);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int popped = stack.pop();
            int breadth = 0;
            if(stack.isEmpty()){
                breadth = heights.length;
            }else{
                breadth = heights.length - (stack.peek()+1);
            }
            result = Math.max(result , heights[popped]*breadth);
        }
        return result;

    }

    public static void main(String[] args) {
        P84LargestRectInHistogram2 p = new P84LargestRectInHistogram2();
        int[] a = {2,1,5,6,2,3};
        System.out.println(p.largestRectangleArea(a));
    }
}
