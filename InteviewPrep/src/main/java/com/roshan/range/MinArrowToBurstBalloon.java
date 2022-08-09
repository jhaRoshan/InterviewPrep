package com.roshan.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinArrowToBurstBalloon {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(points[0][0] , points[0][1]));
        int count = 1;

        for(int i = 1; i < points.length ;i++){
            Interval lastInt = list.get(list.size()-1);
            if(points[i][0] <= lastInt.end){
                lastInt.start = Math.max(points[i][0] , lastInt.start);
                lastInt.end = Math.min(points[i][1] , lastInt.end);
            }else{
                count++;
                list.add(new Interval(points[i][0] , points[i][1]));
            }
        }
        System.out.println(list);
        return count;
    }


    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));

        int[][] points2  = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(points2));
    }
}
