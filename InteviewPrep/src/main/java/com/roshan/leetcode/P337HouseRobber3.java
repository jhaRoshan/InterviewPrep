package com.roshan.leetcode;

public class P337HouseRobber3 {

    public int rob(TreeNode root) {
        int[] rob = robUtil(root);
        return Math.max(rob[0] , rob[1]);
    }


    private int[] robUtil(TreeNode node){

        if(node == null) return new int[2];
        int[] left = robUtil(node.left);
        int[] right = robUtil(node.right);

        int[] curr = new int[2];
        curr[0] = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]);
        curr[1] = left[0] + right[0] + node.val;
        return curr;
    }
}
