package com.roshan.tree.view.left;

import com.roshan.tree.Node;

import java.util.*;

public class LeftViewBFS {


    public List<Integer> getLeftView(Node root){
        List<Integer> retVal  = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node ne = queue.peek();
            retVal.add(ne.getData());

            int size = queue.size();
            for(int i=0; i< size;i++){
                Node n = queue.poll();
                if(n.getLeft() !=null){
                    queue.add(n.getLeft());
                }

                if(n.getRight() !=null){
                    queue.add(n.getRight());
                }
            }
        }
        return retVal;
    }

}
