package com.roshan.leetcode;

public class P265PaintHouse2 {

    public int minCostII(int[][] costs) {

        int row = costs.length;
        int col = costs[0].length;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int prevMinIndex = -1;

        for (int i = 0; i < col; i++) {
            min2 = Math.min(min2, costs[0][i]);
            if (min1 >= costs[0][i]) {
                prevMinIndex = i;
                min2 = min1;
                min1 = costs[0][i];
            }
        }

        System.out.println("min1:"+min1);
        System.out.println("min2:"+min2);
        System.out.println("index:"+prevMinIndex);
        System.out.println("--------------");
        for (int i = 1; i < row; i++) {
            int minx = Integer.MAX_VALUE;
            int miny = Integer.MAX_VALUE;
            int preMinInd = -1;

            for (int j = 0; j < col; j++) {
                int topRowMin = (j == prevMinIndex)  ? min2 : min1;
                int c = costs[i][j] + topRowMin;

                miny = Math.min(miny, c);

                if (minx >= c) {
                    preMinInd = j;
                    miny = minx;
                    minx = c;
                }
            }
            min1 = minx;
            min2 = miny;
            prevMinIndex = preMinInd;
            System.out.println("min1:"+min1);
            System.out.println("min2:"+min2);
            System.out.println("index:"+prevMinIndex);
            System.out.println("--------------");
        }
        return min1;

    }

    public static void main(String[] args) {
        int[][] arr = {{3,20,7,7,16,8,7,12,11,19,1},{10,14,3,3,9,13,4,12,14,13,1},{10,1,14,11,1,16,2,7,16,7,19},{13,20,17,15,3,13,8,10,7,8,9},{4,14,18,15,11,9,19,3,15,12,15},{14,12,16,19,2,12,13,3,11,10,9},{18,12,10,16,19,9,18,4,14,2,4}};
        P265PaintHouse2 p = new P265PaintHouse2();
        int s = p.minCostII(arr);
        System.out.println(s);
    }
}
