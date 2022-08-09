package com.roshan.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static List<Interval> mergeIntervals(int[][] points) {

        List<Interval> retVal = new ArrayList<>();
        Arrays.sort(points , (a,b) -> Integer.compare(a[0], b[0]));
        retVal.add(new Interval(points[0][0] , points[0][1]));


        for (int i = 1; i < points.length; i++) {
            Interval r = retVal.get(retVal.size()-1);
            if(points[i][0] > r.end){
                retVal.add(new Interval(points[i][0] , points[i][1]));
            }else{
                r.start = Math.min(r.start , points[i][0]);
                r.end = Math.max(r.end , points[i][1]);
            }
        }

        return retVal;
    }


    public static void main(String[] args) {

        int[][] arr = {{6,8} , {1,9} , {2,4} , {4,7}};
        System.out.println(mergeIntervals(arr));
    }
}

