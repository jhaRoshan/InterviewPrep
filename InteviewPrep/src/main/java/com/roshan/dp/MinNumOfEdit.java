package com.roshan.dp;

public class MinNumOfEdit {

    public static int findMinEditRec(char[] arr1, char[] arr2, int m, int n){

        if(m== 0 || n==0){
            return Math.max(m,n);
        }

        if(arr1[m-1] == arr2[n-1]){
            return findMinEditRec(arr1,arr2 , m-1 , n-1);
        }

        int rep = 1 +  findMinEditRec(arr1,arr2 , m-1 , n-1);
        int add = 1 +  findMinEditRec(arr1,arr2 , m , n-1);
        int del = 1 +  findMinEditRec(arr1,arr2 , m-1 , n);

        return Math.min(rep , Math.min(add,del));
    }



    public static int findMinEditDP(char[] arr1, char[] arr2, int m, int n){

        int[][] dp = new int[m+1][n+1];

        for(int i= 0 ; i <= n ; i++ ){
            dp[0][i] = i;
        }

        for(int j= 0 ; j <= m ; j++ ){
            dp[j][0] = j;
        }

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{

                int add = dp[i][j-1]+1;
                int del = dp[i-1][j]+1;
                int rep = dp[i-1][j-1]+1;
                dp[i][j] = Math.min(add , Math.min(del,rep));
                }
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {

        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Min Edit is" + " " + findMinEditRec(X, Y, m, n));

        System.out.println("Min Edit is" + " " + findMinEditDP(X, Y, m, n));
    }
}
