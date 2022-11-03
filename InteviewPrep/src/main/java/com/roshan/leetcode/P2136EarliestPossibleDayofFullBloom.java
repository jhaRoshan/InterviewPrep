package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P2136EarliestPossibleDayofFullBloom {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {


        List<Integer> indexes = new ArrayList<>();

        for(int i = 0 ; i < growTime.length;i++){
            indexes.add(i);
        }

        Collections.sort(indexes , Comparator.comparingInt(i -> -growTime[i]));


        int max =0;
        int plantSum=0;


        for(int i = 0 ; i< growTime.length ;i++){

            int index = indexes.get(i);
            int time = plantSum+ plantTime[index] + growTime[index];
            max = Math.max(time , max);
            plantSum = plantSum + plantTime[index];

        }

        return max;
    }
}
