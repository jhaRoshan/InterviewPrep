package com.roshan.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {


    public static List<List<Node>> getAllRootToLeafPaths(Node node){
        List<List<Node>> result = new ArrayList<>();
        getAllRootToLeafPaths(result , node , new ArrayList<>());
        return result;

    }


    private static void getAllRootToLeafPaths(List<List<Node>> result , Node node , List<Node> temp){

        if(node == null){
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(node);
        getAllRootToLeafPaths(result, node.getLeft(), temp);
        getAllRootToLeafPaths(result, node.getRight(), temp);
        temp.remove(temp.size()-1);
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

        List<List<Node>> result = getAllRootToLeafPaths(root);

        for(List<Node> paths: result){
            System.out.println();
            for(Node node:paths){
                System.out.println(node.getData()+" ");
            }
        }


    }




}
