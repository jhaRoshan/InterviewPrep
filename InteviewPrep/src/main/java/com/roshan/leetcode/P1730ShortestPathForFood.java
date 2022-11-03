package com.roshan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P1730ShortestPathForFood {

    public int getFood(char[][] grid) {

        int[] xMove = {0 , 0 , 1, -1};
        int[] yMove = {1 , -1 , 0, 0};


        int startrow = 0;
        int startcol = 0;
        for(int i = 0 ; i < grid.length;i++){
            for(int j = 0 ; j < grid[0].length;j++){
                if(grid[i][j] == '*') {
                    startrow = i; startcol = j; break;
                }
            }
        }

        grid[startrow][startcol] = 'X';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startrow , startcol});
        int count = 0;
        while(!queue.isEmpty()){
            int size= queue.size();
            while(size-- >0){
                int[] poll = queue.poll();
                if(grid[poll[0]][poll[1]] == '#') {
                    return count;
                }
                for(int i = 0 ; i < xMove.length ; i++){

                    int row = poll[0]+ xMove[i];
                    int col = poll[1] + yMove[i];

                    if(grid[row][col] == '#') return count+1;

                    if(isValid(row,col , grid) && grid[row][col] == 'O'){
                        queue.add(new int[]{row,col});
                        grid[row][col] = 'X';
                    }
                }
            }
            count++;
        }
        return -1;

    }

    private boolean isValid(int row, int col , char[][] grid ){
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if(row <0 || col < 0 || row >= rowLen || col >= colLen) return false;
        return true;
    }

    public static void main(String[] args) {
        P1730ShortestPathForFood p =new P1730ShortestPathForFood();

        char[][] arr = {{'X','X','X','X','X','X'},
                {'X','*','O','O','O','X'},
                {'X','O','O','#','O','X'},
                {'X','X','X','X','X','X'}};

        System.out.println(p.getFood(arr));
    }
}
