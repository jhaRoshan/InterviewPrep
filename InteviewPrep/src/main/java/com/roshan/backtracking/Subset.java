package com.roshan.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

	public static List<List<Integer>> getSubset(List<Integer> list){
		
		List<List<Integer>> retVal = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		retVal.add(temp);
		
		getSubsetUtil(list , retVal , new ArrayList<Integer>() , 0);
		return retVal;
		
		
	}
	
	private static void getSubsetUtil(List<Integer> list, List<List<Integer>> retVal, ArrayList<Integer> temp,
			int i) {

		for(int k = i;k<list.size();k++) {
			temp.add(list.get(k));
			retVal.add(new ArrayList<Integer>(temp));
			getSubsetUtil(list, retVal, temp, k+1);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3);
		List<List<Integer>> subset = getSubset(list);
		System.out.println(subset);
	}

}
