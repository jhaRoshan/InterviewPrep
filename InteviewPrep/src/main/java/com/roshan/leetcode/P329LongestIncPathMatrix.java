package com.roshan.leetcode;

public class P329LongestIncPathMatrix {

    private int[] xMove = {0 , 0, 1 , -1};
    private int[] yMove = {1 , -1 , 0 , 0};


    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] cache = new int[m][n];

        int max = 1;
        for(int i = 0 ; i< m;i++){
            for(int j = 0;j < n ;j++){
                int cMax = dfs(matrix , i , j , m, n , cache);
                max = Math.max(max,cMax );
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int rowLen, int colLen , int[][] cache) {

        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;

        for(int k = 0 ; k < xMove.length ; k++){

            int p = i+ xMove[k];
            int q = j + yMove[k];

            if(p < 0 || q < 0 || p >= rowLen || q >= colLen || matrix[i][j] >= matrix[p][q]){
                continue;
            }

            int cMax = 1 + dfs(matrix, p, q, rowLen, colLen , cache);
            max = Math.max(max , cMax);
        }
        cache[i][j] = max;
        return max;

    }

    public static void main(String[] args) {
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
        P329LongestIncPathMatrix p = new P329LongestIncPathMatrix();
        System.out.println(p.longestIncreasingPath(matrix));
    }


}
