package com.roshan.leetcode;

public class P213HouseRobber2 {

    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];

        int s1 = rob1(nums , 0 , nums.length-2);
        int s2 = rob1(nums , 1 , nums.length-1);

        return Math.max(s1,s2);
    }

    public int rob1(int[] nums , int start , int end){
        int prevNotTaken = 0;
        int prevTaken = nums[start];


        for(int i = start+1; i <= end ; i++){
            int currNotTaken = Math.max(prevNotTaken , prevTaken);
            int currTaken = prevNotTaken + nums[i];

            prevNotTaken = currNotTaken;
            prevTaken = currTaken;
        }

        return Math.max(prevNotTaken , prevTaken);
    }

    public static void main(String[] args) {
        P213HouseRobber2 p  = new P213HouseRobber2();
        int[] nums = {1,2,3,1};
        System.out.println(p.rob(nums));
    }
}
