package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P257BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retVal = new ArrayList<>();
        path(root,new ArrayList<TreeNode>() , retVal);
        return retVal;
    }

    private void path(TreeNode root , List<TreeNode> temp , List<String> retVal){

        if(root == null) return;

        temp.add(root);

        if(root.left == null && root.right ==null){
            retVal.add(temp.stream().map(e-> String.valueOf(e.val)).collect(Collectors.joining("->")));
            temp.remove(temp.size()-1);
            return;
        }

        if(root.left != null){
            path(root.left,temp,retVal);
        }

        if(root.right != null){
            path(root.right,temp,retVal);
        }

        temp.remove(temp.size()-1);

    }

    public static void main(String[] args) {
        P257BinaryTreePath p = new P257BinaryTreePath();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        System.out.println(p.binaryTreePaths(n1));
    }
}
