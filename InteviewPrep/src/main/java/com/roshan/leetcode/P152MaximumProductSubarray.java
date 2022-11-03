package com.roshan.leetcode;

public class P152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int result = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] < 0 ){
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i]  , currMax*nums[i]);
            currMin = Math.min(nums[i]  , currMin*nums[i]);

            result = Math.max(result , currMax);
        }
        return result;
    }

    public static void main(String[] args) {
        P152MaximumProductSubarray p = new P152MaximumProductSubarray();
        int[] nums = {2,3,-2,4};
        System.out.println(p.maxProduct(nums));
    }
}
