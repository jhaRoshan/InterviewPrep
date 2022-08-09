package com.roshan.leetcode;

import java.util.Stack;

public class P42RainWaterTrapping {

    public static int trap(int[] height) {

        int result = 0;
        int lMax = 0 ,rMax = 0;

        int start = 0 , end = height.length-1;
        while(start <= end){
            if(lMax < rMax){
                result += Math.max(0 , lMax - height[start]);
                lMax = Math.max(lMax , height[start]);
                start++;
            }else{
                result += Math.max(0 , rMax - height[end]);
                rMax = Math.max(rMax , height[end]);
                end--;
            }
        }
        return result;
    }

    public static int trap2(int[] height)
    {
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int current = 0 ; current < height.length ; current++)
        {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int popped = st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[popped];
                ans += distance * bounded_height;
            }
            st.push(current);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//
//        System.out.println("------------");

        System.out.println(trap(new int[]{6,2,5,4,5,1,6}));
        System.out.println(trap2(new int[]{6,2,5,4,5,1,6}));

    }
}
