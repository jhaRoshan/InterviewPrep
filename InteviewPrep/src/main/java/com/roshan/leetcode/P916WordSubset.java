package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P916WordSubset {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bCounter = new int[26];
        List<String> retVal = new ArrayList<>();
        for(String word: words2){
            int[] counter = counter(word);
            for(int i = 0 ; i < 26;i++){
                bCounter[i] = Math.max(bCounter[i] , counter[i]);
            }
        }

        for(String word: words1){
            if(isUniversal(counter(word) , bCounter)){
                retVal.add(word);
            }
        }
        return retVal;
    }

    private boolean isUniversal(int[] counter, int[] bCounter) {
       for(int i = 0 ; i< 26;i++){
           if(bCounter[i] > counter[i]){
               return false;
           }
       }
       return true;
    }

    private int[] counter(String word){
        int[] counter  = new int[26];
        for(char c: word.toCharArray()){
            ++counter[c-'a'];
        }
        return counter;
    }

    public static void main(String[] args) {
        P916WordSubset p = new P916WordSubset();
        List<String> s = p.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"} , new String[]{"e","o"});
        System.out.println(s);
    }

}
