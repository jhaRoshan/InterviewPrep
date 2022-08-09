package com.roshan.tree.view.right;

import com.roshan.tree.Node;

import java.util.List;

public class RightViewRec {

    private static int intLevel = 0;
    public void getRightView(Node n , int level , List<Integer> retVal){

        if(n == null){
            return;
        }

        if(intLevel < level){
            retVal.add(n.getData());
            intLevel = level;
        }

        getRightView(n.getRight() , level+1 , retVal);
        getRightView(n.getLeft() , level+1 , retVal);

    }


}
