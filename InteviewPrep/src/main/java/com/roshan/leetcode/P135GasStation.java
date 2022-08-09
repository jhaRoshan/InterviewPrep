package com.roshan.leetcode;

import java.util.Arrays;

public class P135GasStation {


    /**
     * Actually, the reason why it works is simple, and it happens because of two factors.
     * First, if you moved to some value, and your total sum is greater than zero, then it means, that previous values did bring some value to the outcome. For example, we have gas = [2,3,0] and cost = [0,0,5]. If we take just solely value 3 without 2, it wouldn't be enough to pass the last station, but previous values definitely bring some value to the outcome.
     * Second, if we know, that there's definitely has to be a solution. Then, we may assume, that it has to be the smallest possible value, as I said before it may bring the most value to the result
     * @param gas
     * @param cost
     * @return
     */

    //https://www.youtube.com/watch?v=lJwbPZGo05A
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum = Arrays.stream(gas).sum();
        int costSum = Arrays.stream(cost).sum();

        if(gasSum < costSum) return -1;
        int start = 0;

        int total = 0;
        for(int i = 0 ; i< gas.length ; i++){
            int diff = gas[i]-cost[i];
            total = total + diff;
            if(total < 0){
                total = 0;
                start = i+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
