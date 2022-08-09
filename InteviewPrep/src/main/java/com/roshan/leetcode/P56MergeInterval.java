package com.roshan.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P56MergeInterval {

    public static int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length ==1 ){
            return intervals;
        }
        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));

        int index = 0;

        for(int i = index+1 ; i < intervals.length ; i++){
            if(intervals[index][1] >= intervals[i][0]){
                intervals[index][1] = Math.max(intervals[index][1] , intervals[i][1]);
            }else{
                index++;
                intervals[index]= intervals[i];
            }
        }
        int[][] retVal = new int[index+1][2];

        for(int i = 0; i <= index;i++){
            retVal[i] = intervals[i];
        }

        return retVal;

    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
