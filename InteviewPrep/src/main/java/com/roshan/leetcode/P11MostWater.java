package com.roshan.leetcode;

public class P11MostWater {

    public static int maxArea(int[] height) {

        int area = 0;

        int i = 0;
        int j = height.length-1;

        while(i < j){
            area = Math.max(area , Math.min(height[i] , height[j]) * (j-i));

            if(height[i] < height[j]) i++;
            else j--;

        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
