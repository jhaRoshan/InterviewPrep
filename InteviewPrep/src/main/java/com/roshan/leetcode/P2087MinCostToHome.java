package com.roshan.leetcode;

public class P2087MinCostToHome {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        int i = startPos[0] , j = startPos[1] , x = homePos[0] , y = homePos[1];

        int cost = 0;
        while(i != x){
            i = i+ (x-i)/Math.abs(x-i);
            cost = cost + rowCosts[i];
        }

        while(j != y){
            j = j+ (y-j)/Math.abs(y-j);
            cost = cost + colCosts[j];
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] startPos = {1, 0}, homePos = {2, 3},
        rowCosts = {5, 4, 3}, colCosts = {8, 2, 6, 7};

        P2087MinCostToHome p = new P2087MinCostToHome();
        System.out.println(p.minCost(startPos,homePos,rowCosts,colCosts));

    }
}
