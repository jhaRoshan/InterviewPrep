package com.roshan.leetcode;


import java.util.Arrays;

//Median of wo sorted array of same size
public class P4MedianOfTwoSortedArr1 {

    public static int getMedian(int[] arr1 , int[] arr2){

        return getMedian(arr1,arr2,0,arr1.length-1 , 0 , arr1.length-1);

    }


    private static  int getMedian(int[] arr1 , int[] arr2 , int fStart , int fEnd , int sStart , int sEnd){

        int fMid = getMedian(arr1 , fStart , fEnd);
        int sMid = getMedian(arr2 , sStart , sEnd);

        int fMidIndex = fStart +(fEnd-fStart)/2;
        int sMidIndex = sStart +(sEnd-sStart)/2;

        if((fEnd - fStart == 1)){
            return (Math.max(arr1[fStart]  , arr2[sStart]) + Math.min(arr1[fEnd]  , arr2[sEnd]))/2;
        }else {
            if(fMid < sMid){
                return  getMedian(arr1, arr2 , fMidIndex , fEnd, sStart,sMidIndex);
            }else{
                return getMedian(arr1, arr2 , fStart , fMidIndex, sMidIndex,sEnd);
            }
        }



    }


    private static  int getMedian(int[] arr1 ,  int start , int end){
        int mid = start + (end-start)/2;
        return arr1[mid];
    }


    public static void main(String[] args) {
        int ar1[] = {1, 12, 15, 26, 38};
//        int ar2[] = {2, 13, 17, 30, 45};
//        int median = getMedian(ar1,ar2);
//        System.out.println(median);
        System.out.println(Arrays.binarySearch(ar1,13));
    }

}
