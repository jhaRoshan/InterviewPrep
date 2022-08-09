package com.roshan.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

	public static List<List<Integer>> getCombination(List<Integer> list , int size){
		
		List<List<Integer>> retVal = new ArrayList<>();
		getSubsetUtil(list , retVal , new ArrayList<Integer>() , 0 ,size);
		return retVal;
		
		
	}
	
	private static void getSubsetUtil(List<Integer> list, List<List<Integer>> retVal, ArrayList<Integer> temp,
			int i, int size) {

		if(temp.size() == size) {
			retVal.add(new ArrayList<Integer>(temp));
			System.out.println(i);
			return;
		}
		
		for(int k = i;k<list.size();k++) {
			temp.add(list.get(k));
			getSubsetUtil(list, retVal, temp, k+1 , size);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4);
		List<List<Integer>> subset = getCombination(list , 2);
		System.out.println(subset);
	}

}
