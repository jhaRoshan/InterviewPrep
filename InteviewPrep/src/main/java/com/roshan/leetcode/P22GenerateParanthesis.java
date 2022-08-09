package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParanthesis {

    public List<String> generateParenthesis(int n) {

        List<String> retVal = new ArrayList<>();
        getParentUtil(n , 0 , 0 , "" , retVal);
        return retVal;
    }

    private void getParentUtil(int n, int open, int close, String res, List<String> retVal) {

        if(close == n){
            retVal.add(res);
            return;
        }

        if(open == close){
            getParentUtil(n, open+1 , close , res+"("  , retVal);
        }

        else if(open > close){
            if (open < n) getParentUtil(n, open+1 , close , res+"("  , retVal);
            getParentUtil(n, open , close+1 , res+")"  , retVal);
        }

    }

    public static void main(String[] args) {
        P22GenerateParanthesis p = new P22GenerateParanthesis();
        System.out.println(p.generateParenthesis(2));
    }

}
