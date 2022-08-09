package com.roshan.range;

import java.util.Arrays;

public class MinNumOfPlatformRequired {

    public static int mindMinPlat(int[][] events){

        int[] start = new int[events.length];
        int[] end = new int[events.length];

        for (int i = 0; i < events.length; i++) {
            start[i] = events[i][0];
            end[i] = events[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int count = 1;
        int result = 1;

        int startInd = 1;
        int endInd = 0;

        while(startInd < start.length && endInd < start.length){
            if(end[endInd] < start[startInd]){
                result--;
                endInd++;
            }else{
                result++;
                startInd++;
            }
            count = Math.max(count, result);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[][] ={ { 900,910}, {940,1200}, {950,1120} ,{1100,1130}, {1500,1900}, {1800,2000} };
        System.out.println(mindMinPlat(arr));
    }
}
