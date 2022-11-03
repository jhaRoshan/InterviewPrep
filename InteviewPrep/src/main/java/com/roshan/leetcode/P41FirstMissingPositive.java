package com.roshan.leetcode;

public class P41FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {


        for(int i = 0 ; i < nums.length ; i++){

            while(nums[i] != i+1){

                if(nums[i] <= 0 || nums[i] >= nums.length){
                    break;
                }


                if(nums[i] == nums[nums[i]-1]){
                    break;
                }

                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;

            }

        }
        for(int i=0 ; i< nums.length ; i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums[nums.length-1]+1;
    }

    public static void main(String[] args) {
        P41FirstMissingPositive p = new P41FirstMissingPositive();
        int[] arr = {-1,2,1,5};
        System.out.println(p.firstMissingPositive(arr));
    }
}
