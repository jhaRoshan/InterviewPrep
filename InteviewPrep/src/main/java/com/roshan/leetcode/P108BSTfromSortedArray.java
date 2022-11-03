package com.roshan.leetcode;

public class P108BSTfromSortedArray {

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0) return null;

        return construct(nums , 0 , nums.length-1);
    }


    private TreeNode construct(int[] nums , int start , int end){

        if(start > end) return null;

        int mid = start + (end-start)/2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = construct(nums , start , mid-1);
        node.right = construct(nums , mid+1 , end);

        return node;
    }

    public static void main(String[] args) {
        P108BSTfromSortedArray p = new P108BSTfromSortedArray();
        TreeNode n = p.sortedArrayToBST(new int[] {-10,-3,0,5,9});
    }
}
