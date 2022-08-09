package com.roshan.leetcode;

import java.util.*;

public class P890FindAndRepPattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int[]  flatPattern = flat(pattern);
        for(String w: words){
            if(Arrays.equals(flat(w) , flatPattern)) res.add(w);
        }
        return res;
    }


    private int[] flat(String w){
        int[] arr = new int[w.length()];
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < w.length() ; i++){
            map.putIfAbsent(w.charAt(i) , map.size());
            arr[i] = map.get(w.charAt(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        P890FindAndRepPattern p =new P890FindAndRepPattern();
        String[] arr = {"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println(p.findAndReplacePattern(arr , "abb"));
    }
}
