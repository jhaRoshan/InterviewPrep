package com.roshan.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P378KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        for(int i = 0; i< colSize ; i++){
            pQueue.add(new int[]{matrix[0][i] , 0 , i});
        }

        int result = 0;

        for(int i = 0; i< k ; i++){
            int[] polled = pQueue.poll();
            result = polled[0];
            int row = polled[1];
            int col = polled[2];

            if(row+1 < rowSize){
                pQueue.add(new int[]{matrix[row+1][col] , row+1 , col});
            }else{
                pQueue.add(new int[]{Integer.MAX_VALUE , Integer.MAX_VALUE , Integer.MAX_VALUE});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P378KthSmallest p = new P378KthSmallest();
        int[][] arr = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(p.kthSmallest(arr,8));

    }
}
