package com.roshan.dp;


import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    /**
     * DP way of solving LIS
     */
    public int longestSubsequenceWithActualSolution(int arr[]){


        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }
        
        //find the index of max number in T 
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }
        
		/*
		 * //lets print the actual solution int t = maxIndex; int newT = maxIndex; do{ t
		 * = newT; System.out.print(arr[t] + " "); newT = actualSolution[t]; }while(t !=
		 * newT); System.out.println();
		 */ 
        
        return T[maxIndex];
    }
    
    /**
     * Recursive way of solving LIS
     */
    public int longestSubsequenceRecursive(int arr[]){
        int maxLen = 0;
        for(int i=0; i < arr.length-1; i++){
            int len = longestSubsequenceRecursive(arr,i+1,arr[i]);
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen + 1;
    }
    
    private int longestSubsequenceRecursive(int arr[], int pos, int lastNum){
        if(pos == arr.length){
            return 0;
        }
        int t1 = 0;
        if(arr[pos] > lastNum){
            t1 = 1 + longestSubsequenceRecursive(arr, pos+1, arr[pos]);
        }
        int t2 = longestSubsequenceRecursive(arr, pos+1, lastNum);
        return Math.max(t1, t2);
    }
    
    public static void main(String args[]){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = {1,2,1,2,3,3,4};
        int result = lis.longestSubsequenceWithActualSolution(arr);
        int result1 = lis.longestSubsequenceRecursive(arr);
        System.out.println(result);
        System.out.println(result1);
    }
}