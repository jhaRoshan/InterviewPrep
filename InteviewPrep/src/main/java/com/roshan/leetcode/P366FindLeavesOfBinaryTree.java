package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P366FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> retval = new ArrayList<>();
        fill(root, retval);
        return retval;
    }

    private int fill(TreeNode node , List<List<Integer>> data){

        if(node == null) return 0;

        int height = 1+ Math.max(fill(node.left , data) , fill(node.right , data));

        if(data.size() < height){
            data.add(new ArrayList<>());
        }
        data.get(height-1).add(node.val);
        return height;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;

        P366FindLeavesOfBinaryTree p = new P366FindLeavesOfBinaryTree();
        System.out.println(p.findLeaves(n1));

    }
}
