package com.roshan.tree.view.right;

import com.roshan.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBFS {


    public List<Integer> getRightView(Node n){

        List<Integer> retVal = new ArrayList<>();

        if(n == null){
            return retVal;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            retVal.add(queue.peek().getData());

            int size = queue.size();

            for(int i = 0 ; i< size ;i++){
                Node ne = queue.poll();
                if(ne.getRight() !=null){
                    queue.add(ne.getRight());
                }
                if(ne.getLeft() !=null){
                    queue.add(ne.getLeft());
                }
            }
        }
        return  retVal;
    }
}
