package com.roshan.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P297SerDeserBTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serialize(root , sb);
        return sb.toString();
    }

    private void serialize(TreeNode node , StringBuilder sb){

        if(node == null){
            sb.append("X").append(",");
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left , sb);
        serialize(node.right , sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeUtil(queue);
    }

    private TreeNode deserializeUtil(Queue<String> queue) {

        String p = queue.poll();
        if(p.equals("X")) return null;

        TreeNode t = new TreeNode(Integer.valueOf(p));
        t.left = deserializeUtil(queue);
        t.right = deserializeUtil(queue);
        return t;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(5);

        P297SerDeserBTree p = new P297SerDeserBTree();
        String s = p.serialize(t1);
        System.out.println(s);

        TreeNode t = p.deserialize(s);
        String s1 = p.serialize(t);
        System.out.println(s1);

    }
}
