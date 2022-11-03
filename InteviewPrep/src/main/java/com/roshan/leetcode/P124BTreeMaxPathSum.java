package com.roshan.leetcode;

import com.roshan.tree.Node;

public class P124BTreeMaxPathSum {

    public int maxPathSum(TreeNode root) {
        return maxPathSumUtil(root);
    }

    private int maxPathSumUtil(TreeNode node){

        if(node == null){
            return 0;
        }

        int lPath = maxPathSumUtil(node.left);
        int rPath = maxPathSumUtil(node.left);
        return Math.max(Math.max(lPath , rPath) , (lPath+rPath+node.val));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(-8);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(0);
        root.right.right.right.left = new TreeNode(4);
        root.right.right.right.right = new TreeNode(-1);
        root.right.right.right.right.left = new TreeNode(10);

        P124BTreeMaxPathSum p = new P124BTreeMaxPathSum();
        System.out.println(p.maxPathSum(root));
    }

}
