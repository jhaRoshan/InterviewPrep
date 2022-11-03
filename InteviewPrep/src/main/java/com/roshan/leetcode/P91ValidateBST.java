package com.roshan.leetcode;

public class P91ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root , Integer.MIN_VALUE , Integer.MAX_VALUE  );
    }

    private boolean isValid(TreeNode node, int min , int max){
        if(node == null) return true;
        if (node.val < min || node.val >  max) {
            return false;
        }
        return isValid(node.left , min , node.val-1) && isValid(node.right , node.val+1 , max);
    }

    public static void main(String[] args) {
        P91ValidateBST p = new P91ValidateBST();

        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(1);
        t.right = new TreeNode(4);
        t.right.left = new TreeNode(3);
        t.right.right = new TreeNode(6);
        System.out.println(p.isValidBST(t));
    }


}
