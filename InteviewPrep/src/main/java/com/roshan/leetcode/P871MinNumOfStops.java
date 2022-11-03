package com.roshan.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class P871MinNumOfStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;
        int maxDist = startFuel , stops = 0 , i = 0;
        Queue<Integer> queue = new PriorityQueue<>((a, b)-> b-a);
        while(maxDist < target){
            while( i < stations.length && stations[i][0] <= maxDist){
                queue.add(stations[i][1]);
                i++;
            }
            if(queue.isEmpty()) return -1;
            maxDist+=queue.poll();
            stops++;
        }
        return stops;
    }

    public static void main(String[] args) {
        P871MinNumOfStops p = new P871MinNumOfStops();
        int[][] station = {{10,60},{20,30},{30,30},{60,40}};
        int x = p.minRefuelStops(100 , 10 , station);
        System.out.println(x);
    }
}
