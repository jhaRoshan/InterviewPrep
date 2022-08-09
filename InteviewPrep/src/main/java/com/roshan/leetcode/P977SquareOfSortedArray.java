package com.roshan.leetcode;

import java.util.Arrays;

public class P977SquareOfSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int[] arr = new int[nums.length];
        int pos = nums.length -1;

        while(start <= end){
            int start2 = nums[start]*nums[start];
            int end2 = nums[end] * nums[end];

            if(end2 > start2){
                arr[pos--] = end2;
                end--;
            }else{
                arr[pos--] = start2;
                start++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = sortedSquares(new int[]{-5,-3,-2,-1});
        System.out.println(Arrays.toString(arr));
    }
}
