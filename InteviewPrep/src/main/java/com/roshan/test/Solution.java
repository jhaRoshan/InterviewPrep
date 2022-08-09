package com.roshan.test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> retVal = new ArrayList<>();
        getParentUtil(n , 0 , 0 , "" , retVal);
        return retVal;
    }
    
    private void getParentUtil(int n , int open , int close , String ans , List<String> retVal){
        
        if(close == n){
            retVal.add(ans);
            return;
        }
        
        if(open > n){
            return;
        }
        
        if(open > close){
            getParentUtil(n , open , close+1 , ans+")" , retVal);
            getParentUtil(n , open+1 , close , ans+"(" , retVal);
        }else{
            getParentUtil(n , open+1 , close , ans+"(" , retVal);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(2));
    }
}