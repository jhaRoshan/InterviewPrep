package com.roshan.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static List<List<Integer>> getCombination(List<Integer> list , int sum){
		
		List<List<Integer>> retVal = new ArrayList<>();
		getSubsetUtil(list , retVal , new ArrayList<Integer>() , 0 ,sum);
		return retVal;

		
	}
	
	private static void getSubsetUtil(List<Integer> list, List<List<Integer>> retVal, ArrayList<Integer> temp,
			int i, int sum) {

		if(sum == 0) {
			retVal.add(new ArrayList<Integer>(temp));
		}

		if(sum < 0) {
			return;
		}


		for(int k = i;k<list.size();k++) {
			temp.add(list.get(k));
			getSubsetUtil(list, retVal, temp, k+1 , sum - list.get(k));
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(2,3,6,7);
		List<List<Integer>> subset = getCombination(list ,7);
		System.out.println(subset);
	}

}
