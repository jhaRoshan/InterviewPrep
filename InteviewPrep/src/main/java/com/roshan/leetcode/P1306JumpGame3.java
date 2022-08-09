package com.roshan.leetcode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P1306JumpGame3 {

    public boolean canReach(int[] arr, int start) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, arr[start]});


        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(pos[1] == 0) return true;
            //add left side index
            if(pos[0] - pos[1] >=0 && arr[pos[0]-pos[1]] !=-1){
                queue.add(new int[]{pos[0]- pos[1] , arr[pos[0]-pos[1]] });
            }
            //add right side index
            if(pos[0] + pos[1] <= arr.length-1 && arr[pos[0]+pos[1]] !=-1){
                queue.add(new int[]{pos[0]+ pos[1] , arr[pos[0]+pos[1]] });
            }
            arr[pos[0]] =-1; // marking as processed
        }
        return false;
    }

    public static void main(String[] args) {
        P1306JumpGame3 p = new P1306JumpGame3();
        int[] arr = {4,2,3,0,3,1,2};
        System.out.println(p.canReach(arr,5));

    }
}
