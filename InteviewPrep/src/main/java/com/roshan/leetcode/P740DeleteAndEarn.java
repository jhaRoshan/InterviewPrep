package com.roshan.leetcode;

public class P740DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        int[] occ =  new int[10001];

        for(int i: nums) occ[i]+= i;

        int prevNotTaken = 0;
        int prevTaken = occ[0];


        for(int i = 1; i < occ.length ; i++){
            int currNotTaken = Math.max(prevNotTaken , prevTaken);
            int currTaken = prevNotTaken + occ[i];

            prevNotTaken = currNotTaken;
            prevTaken = currTaken;
        }

        return Math.max(prevNotTaken , prevTaken);

    }

    public static void main(String[] args) {
        P740DeleteAndEarn p = new P740DeleteAndEarn();
        int[] arr = {2,2,3,3,3,4};
        System.out.println(p.deleteAndEarn(arr));
    }
}
