package com.roshan.leetcode;

public class P2202MaxTopMostElem {

    public int maximumTop(int[] nums, int k) {



        int len = nums.length;

        if(len ==1){
            if(k%2 == 0) return nums[0];
            else return -1;
        }



        if(k==0) return nums[0];
        if(k==1) return nums[1];
        if(k==2) return len > 2 ? Math.max(nums[0] , nums[2]): nums[0];


        int max = 0;
        for(int i = 0 ; i <= k ; i++ ){
            if(i >= len) break;
            if(i == k-1) continue;
            max = Math.max(max , nums[i]);
        }
        return max;

    }
}
