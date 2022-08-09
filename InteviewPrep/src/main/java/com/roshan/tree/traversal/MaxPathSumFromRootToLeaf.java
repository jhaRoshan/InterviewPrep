package com.roshan.tree.traversal;

import com.roshan.tree.Node;

public class MaxPathSumFromRootToLeaf {

    public static int getMaxPathSum(Node root){

        if(root == null){
           return Integer.MIN_VALUE;
        }

        if(root.getLeft() == null && root.getRight() == null){
            return root.getData();
        }

        int lSum = getMaxPathSum(root.getLeft());
        int rSum = getMaxPathSum(root.getRight());

        return Math.max(lSum , rSum) + root.getData();
    }


    public static void main(String[] args) {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(0);
        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);

        System.out.println(getMaxPathSum(root));
    }
}
