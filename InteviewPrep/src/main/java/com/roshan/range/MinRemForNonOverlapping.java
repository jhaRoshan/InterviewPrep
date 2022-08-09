package com.roshan.range;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://www.geeksforgeeks.org/minimum-removals-required-to-make-ranges-non-overlapping/
//https://leetcode.com/problems/non-overlapping-intervals/

public class MinRemForNonOverlapping {

    public static int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int right = 1;
        int count = 0;

        while(right < size){

            //non overlapping
            if(intervals[right][0] >= intervals[left][1]){
                left = right;
                right++;
            }

            else if(intervals[left][1] <= intervals[right][1]){
                right++;
                count++;
            }

            else if(intervals[left][1] > intervals[right][1]){
                left = right;
                right++;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][]  intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

}
