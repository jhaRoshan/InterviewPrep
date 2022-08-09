package com.roshan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P823BinaryTreeWithFactor {

    public int numFactoredBinaryTrees(int[] arr) {

        long mod = (long) (1e9+7);
        long ans = 0L;
        Arrays.sort(arr);
        Map<Integer , Long> map = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i] , 1L);

            for(int j = 0 ; j < i ; j++){
                if(arr[i] % arr[j] == 0){
                    long noOfDivisor = map.get(arr[j]);
                    long noOfDividend = map.getOrDefault(arr[i]/arr[j] , 0L);

                    map.put(arr[i] , (map.get(arr[i]) + noOfDivisor * noOfDividend)%mod);
                }
            }
            ans = (ans + map.get(arr[i]))%mod;
        }
        System.out.println(map);
        return (int) ans;
    }

    public static void main(String[] args) {

        P823BinaryTreeWithFactor p = new P823BinaryTreeWithFactor();
        int[] arr = {2,4};
        System.out.println(p.numFactoredBinaryTrees(arr));
    }
}
