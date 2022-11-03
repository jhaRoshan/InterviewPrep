package com.roshan.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P449SerDeserBST {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder("");
        serUtil(root , sb);
        return sb.toString();
    }

    private void serUtil(TreeNode node , StringBuilder sb){

        if(node == null) return;

        sb.append(node.val).append(",");
        serUtil(node.left , sb);
        serUtil(node.right , sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return  desUtil(queue , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    private TreeNode desUtil(Queue<String> queue , int min , int max){

        if (queue.isEmpty()) return null;

        int p = Integer.valueOf(queue.peek());
        if(p < min || p > max) return null;

        queue.poll();
        TreeNode node = new TreeNode(p);
        node.left = desUtil(queue , min , p);
        node.right = desUtil(queue , p , max);
        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(3);
//        t1.right.left = new TreeNode(6);
//        t1.right.right = new TreeNode(8);

        P449SerDeserBST p = new P449SerDeserBST();
        String s = p.serialize(t1);
        System.out.println(s);

        TreeNode t = p.deserialize(s);
        String s1 = p.serialize(t);
        System.out.println(s1);

    }
}
