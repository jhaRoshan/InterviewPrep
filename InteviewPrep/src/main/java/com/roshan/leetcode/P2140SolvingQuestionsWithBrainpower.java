package com.roshan.leetcode;

public class P2140SolvingQuestionsWithBrainpower {

    public long mostPoints(int[][] questions) {


        long[] dp = new long[questions.length+1];
        return dfs(0 , questions , dp);

    }

    private long dfs( int index , int[][] questions , long[] dp){

        if(index >= questions.length) return 0;

        if(dp[index] != 0) return dp[index];

        int value = questions[index][0];
        int nextIndex = index + questions[index][1]+1;

        return dp[index] = Math.max(value+ dfs(nextIndex , questions, dp ) , dfs(index+1 , questions , dp));


    }

    public static void main(String[] args) {
        int[][] arr = {{3,2},{4,3},{4,4},{2,5}};
        P2140SolvingQuestionsWithBrainpower p  = new P2140SolvingQuestionsWithBrainpower();
        System.out.println(p.mostPoints(arr));
    }
}
