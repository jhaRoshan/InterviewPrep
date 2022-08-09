package com.roshan.tree.view.left;

import com.roshan.tree.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeftViewRec {


    public void getLeftView(Node n , int level , Set<Integer>visitedLevel, List<Integer> retVal){
        if(n == null){
            return;
        }

        if(!visitedLevel.contains(level)){
            retVal.add(n.getData());
            visitedLevel.add(level);
        }
        getLeftView(n.getLeft() , level+1 , visitedLevel , retVal);
        getLeftView(n.getRight() , level+1 , visitedLevel , retVal);
    }

}

