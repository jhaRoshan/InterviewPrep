package com.roshan.leetcode;

import java.util.Stack;

public class P85MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i< matrix[0].length;i++){
            dp[0][i] = matrix[0][i] - '0';
        }

        for(int i = 1; i< matrix.length;i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == '1')
                dp[i][j] = dp[i-1][j] + (matrix[i][j] - '0');
            }
        }

        int result = 0;
        for(int i = 0; i< matrix.length;i++){
            result = Math.max(result , findHistArea(dp[i]));
        }
        return result;
    }

    private int findHistArea(int[] matrix) {

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i = 0;i < matrix.length ;i++){
            while(!stack.isEmpty() && matrix[stack.peek()] > matrix[i] ){

                int popped = stack.pop();
                int len = matrix[popped];
                int breadth = 0;
                if(stack.isEmpty()){
                    breadth = i;
                }else{
                    breadth = i - (stack.peek()+1);
                }
                int currentArea = len*breadth;
                area = Math.max(area,currentArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int popped = stack.pop();
            int len = matrix[popped];
            int breadth = 0;
            if(stack.isEmpty()){
                breadth = matrix.length;
            }else{
                breadth = matrix.length - (stack.peek()+1);
            }
            int currentArea = len*breadth;
            area = Math.max(area,currentArea);
        }
        return area;
    }


}
