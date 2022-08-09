package com.roshan.tree.view.top;

import com.roshan.tree.Node;

import java.util.*;

public class TopViewRec {

    public List<Integer> getTopView(Node n){

        List<Integer> retVal = new ArrayList<>();
        Map<Integer , Integer> map = new TreeMap<>();
        getTopViewUtil(n , map , 0);

        for(Map.Entry<Integer , Integer> m:map.entrySet()){
            retVal.add(m.getValue());
        }
        return retVal;
    }

    public void getTopViewUtil(Node n , Map<Integer,Integer> retVal , int pos){

        if(n == null){
            return;
        }

        getTopViewUtil(n.getLeft() , retVal , pos-1);
        getTopViewUtil(n.getRight() , retVal , pos+1);
        retVal.put(pos , n.getData());

    }
}
