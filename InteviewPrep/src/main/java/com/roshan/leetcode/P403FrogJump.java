package com.roshan.leetcode;

import java.util.*;

public class P403FrogJump {

    public boolean canCross(int[] stones) {

        Map<Integer , Set<Integer>> indexToSteps = new HashMap<>();
        for(int s:stones) indexToSteps.put(s , new HashSet<>());

        indexToSteps.put(0 , new HashSet<>());
        indexToSteps.get(0).add(1);

        for(int i = 0 ; i < stones.length-1 ; i++){
            int stone  = stones[i];
            for(int step: indexToSteps.get(stone)){
                int reach = stone + step;
                if(reach == stones[stones.length-1]) return true;
                if(indexToSteps.get(reach) != null){
                    indexToSteps.get(reach).add(step);
                    if(step-1 > 0) indexToSteps.get(reach).add(step-1);
                    indexToSteps.get(reach).add(step+1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P403FrogJump p = new P403FrogJump();
        System.out.println(p.canCross(new int[] {0,1,3,4,5,7,9,10,12}));
        System.out.println(p.canCross(new int[] {0,1,2,3,4,8,9,11}));
        System.out.println(p.canCross(new int[] {0,1,3,5,6,8,12,17}));
//
        System.out.println(p.canCross(new int[] {0,1,3,6,7}));
    }
}
