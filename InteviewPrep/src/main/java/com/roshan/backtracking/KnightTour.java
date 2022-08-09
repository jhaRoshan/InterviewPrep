package com.roshan.backtracking;

import java.util.Arrays;

public class KnightTour {

    private static  int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };


//    private static  int xMove[] = {  1,1,-1,-1 ,2,2,-2,-2 };
//    private static int yMove[] = { 2,-2,2,-2,1,-1,1,-1 };





    public static void printTour(){

        int[][] board = new int[8][8];
        Arrays.stream(board).forEach(a -> Arrays.fill(a, -1));
        board[0][0] = 0;
        solveKTUtil( 0,0, 1 , board);
        System.out.println(Arrays.deepToString(board));
    }

    private static boolean solveKTUtil( int x  , int y , int  movei,int[][] sol){

        if( movei == 64)
            return true;

        for( int k = 0 ; k <8 ; k++){
            int next_x = x+xMove[k];
            int next_y = y + yMove[k];
            if(isSafe(next_x,next_y ,sol)){
                sol[next_x][next_y] =  movei;
                if(solveKTUtil(next_x, next_y,  movei+1,sol)){
                    return true;
                }
                sol[next_x][next_y] =-1;
            }
        }
        return false;
    }



    private static boolean isSafe(int x, int y, int[][] board) {
        if(x<0 || x > 7 || y < 0 || y > 7){
            return false;
        }
        if(board[x][y] !=-1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        printTour();
    }

}
