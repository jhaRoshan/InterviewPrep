package com.roshan.tree.traversal;

import com.roshan.tree.Node;
import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSumLeafToLeaf {

    public static int getMaxPathSum(Node root){
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        getMaxPathSumUtil(root , result);
        return result.get();
    }

    private static int getMaxPathSumUtil(Node root , AtomicInteger result){

        if(root == null){
            return 0;
        }

        int lSum = getMaxPathSumUtil(root.left , result);
        int rSum = getMaxPathSumUtil(root.right , result);

        if(root.getLeft() != null && root.getRight() != null){
            result.set(Math.max(result.get(), lSum+ rSum + root.getData()));
        }

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
        System.out.println("Max pathSum of the given binary tree is "
                + getMaxPathSum(root));
    }


}
