package com.roshan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P179LargestNumber {
    public String largestNumber(int[] num) {

        for(int i = 0 ; i < num.length ; i++){
            for(int j = i+1 ; j < num.length ; j++){
                String s1 = num[i] + String.valueOf(num[j]);
                String s2 = num[j] + String.valueOf(num[i]);
                if(s1.compareTo(s2) < 1){
                    swap(num , i , j);
                }
            }
        }

        if(num[0] == 0) return "0";
        StringBuilder sb = new StringBuilder("");
        for(int n: num) sb.append(n);
        return sb.toString();
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }

    public static void main(String[] args) {
        P179LargestNumber p = new P179LargestNumber();
        System.out.println(p.largestNumber(new int[] {1,2,3,5,4}));
    }
}
