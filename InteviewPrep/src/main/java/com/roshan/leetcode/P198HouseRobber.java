package com.roshan.leetcode;

public class P198HouseRobber {

    public int rob(int[] nums) {

        int prevNotTaken = 0;
        int prevTaken = nums[0];


        for(int i = 1; i < nums.length ; i++){
            int currNotTaken = Math.max(prevNotTaken , prevTaken);
            int currTaken = prevNotTaken + nums[i];

            prevNotTaken = currNotTaken;
            prevTaken = currTaken;
        }

        return Math.max(prevNotTaken , prevTaken);
    }

    public static void main(String[] args) {
        P198HouseRobber p = new P198HouseRobber();
        int[] arr = {1,2,3,1};
        System.out.println(p.rob(arr));
    }
}
