package com.roshan.stock;

public class MaxProfit {

	
	public static int getMaxprofit(int[] price) {
		
		int i = 0;
		int n = price.length;
		
		while(i+1 < n) {
			
			while(i < n-1 && price[i] > price[i+1]) {
				i++;
			}
			int start = i;
			
			while( i < n-1 && price[i] < price[i+1]) {
				i++;
			}
			int end =i;
			
			System.out.println(start +" " + end);
		}
		
		return 0;
		
	}
	public static void main(String[] args) {
		
		int[] price = {100,180,260,310,40,535,695};
		getMaxprofit(price);
		
		
		int[] price1 = {2,5,7,1,4,3,1,3};
		getMaxprofit(price1);
	}

}
