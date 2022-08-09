package com.roshan.backtracking;


//https://leetcode.com/problems/word-search/
class WordSearch {

    public boolean exist(char[][] board, String word) {
    
        int rowLen = board.length;
        int colLen = board[0].length;
        
        for(int i = 0 ; i< rowLen;i++){
            for(int j = 0;j< colLen;j++){
                if(doesExist(board , word , i,j ,0,rowLen,colLen)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    
    public boolean doesExist(char[][] board , String word , int row , int col , int index,int rowLen, int colLen){
        
        if(index == word.length()){
            return true;
        }
        
        
        if(!isValid(row,col,rowLen , colLen)){
            return false;
        }
        
        if(word.charAt(index) == board[row][col]){
            board[row][col] = '#';
            boolean result = (doesExist(board , word , row+1 , col , index+1 , rowLen , colLen)
                || doesExist(board , word , row-1 , col , index+1,rowLen , colLen)
                || doesExist(board , word , row , col+1 , index+1,rowLen , colLen)
                || doesExist(board , word , row , col-1 , index+1,rowLen , colLen));
            board[row][col] = word.charAt(index);
            return result;
        }
        
        return false;
        
    }
    
    private boolean isValid(int row,int col , int rowLen , int colLen){
        if(row < 0 || row >= rowLen){
            return false;
        }
        
        if(col < 0 || col >= colLen){
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A','B','C','E'} , {'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(ws.exist(board,"ABCB"));

    }
    
}