package com.roshan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int result = 0;
        Map<Integer , Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0,1);
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum+nums[i];
            result = result + prefixSumFreq.getOrDefault(sum-k , 0);
            prefixSumFreq.put(sum , prefixSumFreq.getOrDefault(sum,0)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        P560SubarraySumEqualsK s = new P560SubarraySumEqualsK();
        int[] nums = {-2,1,2,-2,5,-2,1};
        System.out.println(s.subarraySum(nums , 3));

        System.out.println(23%6);
    }
}
