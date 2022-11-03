package com.roshan.leetcode;

import java.util.Arrays;

public class P45JumpGane2 {


    public static int jump(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr , nums.length+1); //as Integer.Max was overflowing
        arr[nums.length-1] = 0;

        for(int  i = nums.length-1 ; i >=0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(j+ nums[j] >= i) {
                    arr[j] = Math.min(arr[j] , arr[i]+1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[0];
    }

    public static int jump2(int[] nums) {

        int end = 0,farthest=0,jump=0;
        for (int i = 0 ; i < nums.length-1 ; i++){
            farthest = Math.max(farthest , i+ nums[i]);
            if( i== farthest) return -1; //not possible to reach end
            if(i == end){
                jump++;
                end = farthest;
            }
        }
        return jump;
    }

    public static void main(String[] args) {

//        System.out.println(jump(new int[]{2,3,0,1,4}));
        System.out.println(jump2(new int[]{2,3,0,1,4}));
        System.out.println(jump2(new int[]{3,1,5,6,7,8}));



//        System.out.println("-----");
//        System.out.println(jump(new int[]{2,0,0}));
        System.out.println(jump2(new int[]{2,0,0}));
//
//        System.out.println("-----");
//        System.out.println(jump(new int[]{1,0,0})); //this has some problem
        System.out.println(jump2(new int[]{1,0,0}));
    }


}
