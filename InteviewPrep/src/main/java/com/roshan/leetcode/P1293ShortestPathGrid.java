package com.roshan.leetcode;

import java.util.*;

public class P1293ShortestPathGrid {

    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] visited = new boolean[n][m][k+1];

        Queue<int[]> q = new LinkedList();

        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});

        int res = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0; i<size; i++){
                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r==n-1 && c==m-1){
                    return res;
                }

                for(int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;

                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<m){

                        if(grid[nextR][nextC]==1){
                            nextK++;
                        }

                        if(nextK<=k && !visited[nextR][nextC][nextK]){
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }

            }
            res++;
        }
        return -1;

    }
    public static void main(String[] args) {
        P1293ShortestPathGrid p = new P1293ShortestPathGrid();
        int[][] arr = {{0,1,1},{1,1,1},{1,0,0}};
        System.out.println(p.shortestPath(arr,1));


        int[][] arr1 = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        System.out.println(p.shortestPath(arr1,1));
    }
}
