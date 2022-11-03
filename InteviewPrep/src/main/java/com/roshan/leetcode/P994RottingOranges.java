package com.roshan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P994RottingOranges {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int freshOrange = 0 ;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }

        int count = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0 ; i < size ; i++){

                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];

                //up
                if(row-1 >= 0 && col >=0 && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    freshOrange--;
                    queue.add(new int[]{row-1,col});
                }

                //left
                if(col-1 >=0 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    freshOrange--;
                    queue.add(new int[]{row,col-1});
                }

                //right
                if(col+1 < n && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    freshOrange--;
                    queue.add(new int[]{row,col+1});
                }

                //down
                if(row+1 < m && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    freshOrange--;
                    queue.add(new int[]{row+1,col});
                }

            }

            if(queue.size() > 0) count++;
            if(queue.size() == 0 ) break;

        }
        return freshOrange == 0 ? count:-1;

    }

    public static void main(String[] args) {
        P994RottingOranges p = new P994RottingOranges();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(p.orangesRotting(grid));
    }
}
