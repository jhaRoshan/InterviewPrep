package com.roshan.leetcode;

import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.util.Arrays;

public class P238ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] retVal = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = 1;
        for(int i = 1 ; i < nums.length;i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        rightProduct[nums.length-1] = 1;
        for(int i = nums.length-2 ; i >= 0; i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        for(int i = 0 ;i < nums.length;i++){
            retVal[i] = leftProduct[i] * rightProduct[i];
        }
        return retVal;
    }

    public static void main(String[] args) {
        P238ProductArrayExceptSelf p = new P238ProductArrayExceptSelf();
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(p.productExceptSelf(arr)));
    }
}
