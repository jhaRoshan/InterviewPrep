package com.roshan.leetcode;

public class P670MaxSwap {

    public int maximumSwap(int num) {

        char[] digits = String.valueOf(num).toCharArray();

        int[] maxIdx = new int[digits.length];
        int maxPos = digits.length -1;
        maxIdx[maxPos] = maxPos;

        for(int i = digits.length-2; i >=0 ;i--){
            if(digits[maxPos] < digits[i]) {
                maxPos = i;
            }
            maxIdx[i] = maxPos;
        }

        for(int i = 0 ; i< digits.length ;i++){
            if(digits[maxIdx[i]] > digits[i]){
                swap(digits , maxIdx[i] , i);
                break;
            }
        }
        return Integer.parseInt(String.valueOf(digits));

    }

    private void swap(char[]s, int i , int j){

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        P670MaxSwap p = new P670MaxSwap();
        System.out.println(p.maximumSwap(98368));
    }
}
