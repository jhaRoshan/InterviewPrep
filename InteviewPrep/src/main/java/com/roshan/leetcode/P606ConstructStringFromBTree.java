package com.roshan.leetcode;

public class P606ConstructStringFromBTree {

    public String tree2str(TreeNode root) {

        return construct(root);
    }

    private String construct(TreeNode node ){

        if(node == null) return null;

        String left = construct(node.left);
        String right = construct(node.right);

        if(left == null && right == null) return  node.val+"";
        else if(right == null) return node.val+"("+left+")";
        else if(left == null) return node.val+"()"+"("+right+")";
        else return node.val+"("+left+")"+"("+right+")";
    }

    public static void main(String[] args) {
        P606ConstructStringFromBTree p = new P606ConstructStringFromBTree();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);

        System.out.println(p.tree2str(t1));
    }
}
