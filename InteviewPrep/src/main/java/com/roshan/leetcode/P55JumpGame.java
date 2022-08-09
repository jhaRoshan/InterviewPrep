package com.roshan.leetcode;

public class P55JumpGame {

    public boolean canJump(int[] nums) {

        int end = 0;
        for(int i = 0 ; i < nums.length;i++){
            end = Math.max(end , i+nums[i]);
            if(end >= nums.length-1) return true;
            if(i == end) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        P55JumpGame p = new P55JumpGame();
        System.out.println(p.canJump(new int[]{2,3,1,1,4}));
        System.out.println(p.canJump(new int[]{3,2,1,0,4}));
    }
}
