package com.roshan.leetcode;

import java.util.Arrays;

public class P34FirstLastPos {



    public int[] searchRange(int[] nums, int target) {
        return new int[]{getFirstOcc(nums,target) , getLastOcc(nums,target)};

    }

    private int getFirstOcc(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        int pos = -1;

        while(start <= end){
            int middle = start + (end-start)/2;
            if(nums[middle] == target){
                pos = middle;
                end = middle-1;
            }
            else if(nums[middle] < target){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return pos;
    }

    private int getLastOcc(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        int pos = -1;

        while(start <= end){
            int middle = start + (end-start)/2;
            if(nums[middle] == target){
                pos = middle;
                start = middle+1;
            }
            else if(nums[middle] < target){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return pos;
    }


    public static void main(String[] args) {
        int[] res = new P34FirstLastPos().searchRange(new int[]{5,7,7,8,8,10} , 8);
        System.out.println(Arrays.toString(res));
    }


}
