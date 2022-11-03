package com.roshan.leetcode;

import java.util.*;

public class P818RaceCar {

    public int racecar(int target) {

        Queue<StepCal> queue = new LinkedList<>();
        Set<StepCal> set = new HashSet<>();

        StepCal s = new StepCal(0,1);
        queue.add(s);
        set.add(s);

        int level = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while(size-->0){

                StepCal poll = queue.poll();
                if(poll.pos == target){
                    return level;
                }

                StepCal s1 = new StepCal(poll.pos+ poll.speed, 2* poll.speed);
                if(!set.contains(s1) && Math.abs(s1.pos-target) < target){
                    if(!set.contains(s1)){
                        queue.add(s1);
                        set.add(s1);
                    }
                }

                s1 = new StepCal(poll.pos, poll.speed>0?-1:1);
                if(!set.contains(s1) && Math.abs(s1.pos-target) < target){
                    queue.add(s1);
                    set.add(s1);
                }
            }
        }
        return level;

    }



    public static void main(String[] args) {
        P818RaceCar p = new P818RaceCar();
        System.out.println(p.racecar(3));
    }
}

class StepCal{
    int pos;
    int speed;

    public StepCal(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepCal stepCal = (StepCal) o;
        return pos == stepCal.pos && speed == stepCal.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, speed);
    }
}