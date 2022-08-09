package com.roshan.tree.view.bottom;

import com.roshan.tree.Node;

import java.util.*;

public class BottomViewBFS {

    public List<Integer> getBottomView(Node n){

        List<Integer> list = new ArrayList<>();
        Map<Integer , Integer> map = new TreeMap<>();

        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();

        nodeQueue.add(n);
        posQueue.add(0);

        while(!nodeQueue.isEmpty()){

            Node ne = nodeQueue.poll();
            int pos = posQueue.poll();

             map.put(pos, ne.getData());

            if(ne.getLeft() != null){
                nodeQueue.add(ne.getLeft());
                posQueue.add(pos-1);
            }

            if(ne.getRight() != null){
                nodeQueue.add(ne.getRight());
                posQueue.add(pos+1);
            }

        }

        for(Map.Entry<Integer , Integer> m:map.entrySet()){
            list.add(m.getValue());
        }
        return list;
    }
}
