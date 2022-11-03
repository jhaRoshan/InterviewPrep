package com.roshan.leetcode;

public class P2328NumberOfIncPathGrid {

    private int[] xMove = {0 , 0, 1 , -1};
    private int[] yMove = {1 , -1 , 0 , 0};

    private int mod = (int) (1e9+7);

    public int countPaths(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] cache = new int[m][n];

        long count = 0;
        for(int i = 0 ; i< m;i++){
            for(int j = 0;j < n ;j++){
                long cCount = dfs(matrix , i , j , m, n , cache);
                count = (count + cCount) % mod;
            }
        }
        return (int) count;
    }
    private long dfs(int[][] matrix, int i, int j, int rowLen, int colLen , int[][] cache) {

        if(cache[i][j] != 0) return cache[i][j];
        long count = 1;

        for(int k = 0 ; k < xMove.length ; k++){

            int p = i+ xMove[k];
            int q = j + yMove[k];

            if(p < 0 || q < 0 || p >= rowLen || q >= colLen || matrix[i][j] >= matrix[p][q]){
                continue;
            }

            count = (1 + dfs(matrix, p, q, rowLen, colLen , cache) ) % mod;
        }
        cache[i][j] = (int) count;
        return count;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1},{3,4}};
        P2328NumberOfIncPathGrid p = new P2328NumberOfIncPathGrid();
        System.out.println(p.countPaths(matrix));
    }



}
