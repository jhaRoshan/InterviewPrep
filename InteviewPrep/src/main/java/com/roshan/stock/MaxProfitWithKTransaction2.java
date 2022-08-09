package com.roshan.stock;

public class MaxProfitWithKTransaction2 {



    private static int getMaxprofit(int[] prices, int k) {

        int buyIndex = 0 ; int sellIndex = 0;
        int len = prices.length;
        int index = 0;

        while (index+1 < len) {

            while ( index + 1 < len && prices[index] > prices[index + 1]) {
                index++;
            }
            buyIndex = index;

            while (index + 1 < len && prices[index] < prices[index + 1] ) {
                index++;
            }
            sellIndex = index;

            System.out.println("But at index:" + buyIndex + " and sell at index:" + sellIndex);

        }
        return 0;

    }


    public static void main(String[] args) {
        int[] prices = {2,5,7,1,4,3,1,3};
        System.out.println(getMaxprofit(prices, 3));

    }



}



