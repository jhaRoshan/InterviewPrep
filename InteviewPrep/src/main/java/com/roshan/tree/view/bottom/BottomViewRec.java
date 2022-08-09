package com.roshan.tree.view.bottom;

import com.roshan.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewRec {

    public List<Integer> getBottomView(Node n){

        List<Integer> retVal = new ArrayList<>();
        Map<Integer , Integer> map = new TreeMap<>();
        getBottomViewUtil(n , map , 0);

        for(Map.Entry<Integer , Integer> m:map.entrySet()){
            retVal.add(m.getValue());
        }
        return retVal;
    }

    public void getBottomViewUtil(Node n , Map<Integer,Integer> retVal , int pos){

        if(n == null){
            return;
        }

        getBottomViewUtil(n.getLeft() , retVal , pos-1);
        getBottomViewUtil(n.getRight() , retVal , pos+1);
        retVal.putIfAbsent(pos , n.getData());

    }
}
