package com.roshan.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/submissions/
class NonDuplicateCombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> retVal = new ArrayList<>();
        Arrays.sort(candidates);
		getSubsetUtil(candidates , retVal , new ArrayList<Integer>() , 0 ,target);
		return retVal;
    }
    
    private  void getSubsetUtil(int[] list, List<List<Integer>> retVal,        ArrayList<Integer> temp,
			int i, int sum) {

		if(sum == 0) {
			retVal.add(new ArrayList<Integer>(temp));
		}

		if(sum < 0) {
			return;
		}

        int prev = -1;
		for(int k = i;k<list.length;k++) {
            if(prev != list[k]){
               temp.add(list[k]);
                getSubsetUtil(list, retVal, temp, k+1 , sum - list[k]);
                temp.remove(temp.size()-1); 
                prev = list[k];
            }
			
		}
	}
}