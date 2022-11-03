package com.roshan.leetcode;

public class P130SurroundedRegion {
    public void solve(char[][] board) {


        int rowLen = board.length;
        int colLen = board[0].length;

        if(rowLen <= 2 || colLen <= 2) return;


        for(int i = 0 ; i < colLen ;i++){
            solveUtil(board , rowLen ,colLen , 0 , i);
            solveUtil(board ,rowLen ,colLen , rowLen-1 , i);
        }

        for(int i = 0 ; i < rowLen ;i++){
            solveUtil(board ,rowLen ,colLen , i , 0);
            solveUtil(board ,rowLen ,colLen , i , colLen-1);
        }


        for(int i = 0 ; i < rowLen;i++){
            for(int j = 0; j< colLen;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }



    }


    private void solveUtil(char[][] board , int m , int n , int i , int j){


        if(i < 0 || j < 0 || i >=m || j>=n || board[i][j] != 'O' ) return;

        board[i][j] ='#';

        solveUtil(board , m, n, i+1,j);
        solveUtil(board , m, n, i-1,j);
        solveUtil(board , m, n, i,j+1);
        solveUtil(board , m, n, i,j-1);

    }

}
