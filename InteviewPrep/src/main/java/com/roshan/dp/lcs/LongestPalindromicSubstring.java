package com.roshan.dp.lcs;

import java.util.Arrays;

public class LongestPalindromicSubstring {


    private static String  getLongestSubstring(String input){


        int start = 0,maxLen = 0;

        char[] arr = input.toCharArray();

        //dp[i][j] represent if String is palindrome from i to j;
        boolean[][] dp = new boolean[arr.length][arr.length];

        
        //all diagonal are palindrome since one character is always palindrome
        for(int i = 0 ; i < arr.length;i++){
            dp[i][i] = true;
            start=i;
            maxLen=1;
        }

        //fill 2nd character, as with frst charated it was always palindrome,
        // second character makes it palindrome if it is equal to first character
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]){
                dp[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }

        //from 3rd character onwards it will be palindrome if last and 1st is same
        //and middle are palindrome
        //(i , j) is palindrome if  i == j and character between i and j is palindrome

        for (int k=3; k<= arr.length;k++){
            for (int i = 0 ; i < arr.length-k+1 ; i++){
                int j = i+k-1;
                if(arr[i] == arr[j] && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(k > maxLen){
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }

        return input.substring(start , start+maxLen);


    }

    public static void main(String[] args) {
        System.out.println(getLongestSubstring("aaaabbaa"));
        System.out.println(getLongestSubstring("forgeeksskeegfor"));

    }

}
