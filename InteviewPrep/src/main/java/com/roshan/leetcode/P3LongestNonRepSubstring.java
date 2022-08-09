package com.roshan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P3LongestNonRepSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int startIndex = 0;
        int max = 0;

        Map<Character , Integer> charIndex = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(charIndex.get(s.charAt(i)) != null){
                startIndex = Math.max(startIndex,charIndex.get(s.charAt(i))+1);
            }
            charIndex.put(s.charAt(i) , i);
            max = Math.max(max , i-startIndex+1);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }


}
