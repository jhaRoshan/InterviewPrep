package com.roshan.test;

import java.util.*;

public class Solution {

    int[][] d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int minimumObstacles(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] di : dist) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[3]);


        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int o = cur[0], r = cur[1], c = cur[2];
            for(int[] dir : d){
                int i = dir[0] + r;
                int j = dir[1] + c;

                if (0 <= i && i < m && 0 <= j && j < n && dist[i][j] == Integer.MAX_VALUE) {
                    if (grid[i][j] == 1) {
                        dist[i][j] = o + 1;
                        dq.offer(new int[]{o + 1, i, j});
                    }else {
                        dist[i][j] = o;
                        dq.offerFirst(new int[]{o, i, j});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr1 = {{0,1,1},{1,1,0},{1,1,0}};
        System.out.println(s.minimumObstacles(arr1));
    }
}