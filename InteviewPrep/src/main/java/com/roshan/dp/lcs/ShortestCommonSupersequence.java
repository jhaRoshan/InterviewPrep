package com.roshan.dp.lcs;


public class ShortestCommonSupersequence {

    public static int getShortestSuperSeq(String str1, String str2){
        return str1.length() + str2.length() - getLCS(str1.toCharArray() , str2.toCharArray());
    }

    private static int getLCS(char[] str1 ,  char[] str2){

        int[][] dp = new int[str1.length+1][str2.length+1];

        for(int i = 0 ; i <= str1.length ; i++){
            dp[i][0] = 0;
        }

        for(int j = 0 ; j <= str2.length ; j++){
            dp[0][j] = 0;
        }

        for(int i = 1;i<= str1.length ; i++){
            for(int j = 1; j <= str2.length ; j++){
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] ,  dp[i][j-1]);
                }
            }
        }
        return dp[str1.length][str2.length];
    }


    public static void main(String[] args) {
        System.out.println(getShortestSuperSeq("AGGTAB","GXTXAYB"));
        System.out.println(getShortestSuperSeq("geek" , "eke"));

    }

}
