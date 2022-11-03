package com.roshan.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class P1024VidoeStitching {


    public int videoStitching(int[][] clips, int time) {

        Arrays.sort(clips , Comparator.comparingInt(a -> a[0]));

        int start = 0 ; int end =0 , index = 0;
        int count=0;

        while(end < time){
            for( ; index < clips.length && clips[index][0] <= start ;){
                end = Math.max(end, clips[index][1]);
                index++;
            }


            if(start == end) return -1;
            start = end;
            count++;
        }

        return count;
    }

    public int videoStitching2(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a,b) ->  a[0] - b[0]);
        for (int i = 0, st = 0, end = 0; st < T; st = end, ++res) {
            for (; i < clips.length && clips[i][0] <= st; ++i)
                end = Math.max(end, clips[i][1]);
            if (st == end) return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        P1024VidoeStitching p = new P1024VidoeStitching();
        System.out.println(p.videoStitching(arr, 10));
        arr = new int[][]{{0, 1}, {1, 2}};
        System.out.println(p.videoStitching(arr , 5));

        arr = new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        System.out.println(p.videoStitching(arr , 9));
    }


}
