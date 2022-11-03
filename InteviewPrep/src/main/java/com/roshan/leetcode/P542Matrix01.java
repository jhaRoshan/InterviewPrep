package com.roshan.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P542Matrix01 {

    int[][] d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < m ; i++){
            for(int j= 0 ; j< n;j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            for(int[] dir : d){
                int i = dir[0] + r;
                int j = dir[1] + c;

                if (0 <= i && i < m && 0 <= j && j < n && mat[i][j] >= mat[r][c]+1) {
                    mat[i][j] = mat[r][c]+1;
                    queue.add(new int[]{i,j});
                }

            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        P542Matrix01 p = new P542Matrix01();
        System.out.println(Arrays.deepToString(p.updateMatrix(mat)));
    }
}
