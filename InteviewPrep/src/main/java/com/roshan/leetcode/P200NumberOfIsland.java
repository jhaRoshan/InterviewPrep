package com.roshan.leetcode;

public class P200NumberOfIsland {

    public int numIslands(char[][] grid) {

        int count = 0;
        if(grid == null) return count;

        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j< grid[0].length ;j++){
                if(grid[i][j] == '1'){
                    traverse(grid , i , j);
                    count++;
                }
            }
        }
        return count;
    }

    private void traverse(char[][] grid, int i, int j) {

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;

        if(grid[i][j] == '0') return;

        grid[i][j] = '0';

        traverse(grid, i+1, j);
        traverse(grid, i-1, j);
        traverse(grid, i, j+1);
        traverse(grid, i, j-1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        P200NumberOfIsland p = new P200NumberOfIsland();
        System.out.println(p.numIslands(grid));
    }
}
