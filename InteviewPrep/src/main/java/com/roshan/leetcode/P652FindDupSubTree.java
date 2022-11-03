package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P652FindDupSubTree {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        postOrder(root , map, ans);
        return ans;
    }


    private String postOrder(TreeNode node , Map<String,Integer> map , List<TreeNode> ans){

        if(node == null) return "X";

        String curr = node.val + "," + postOrder(node.left , map , ans) +","+postOrder(node.right , map,ans);

        map.put(curr , map.getOrDefault(curr,0)+1);

        if(map.get(curr) == 2){
            ans.add(node);
        }
        return curr;
    }



}
