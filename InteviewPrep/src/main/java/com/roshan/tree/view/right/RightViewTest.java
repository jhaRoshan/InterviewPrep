package com.roshan.tree.view.right;

import com.roshan.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class RightViewTest {
    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);


        n1.setLeft(n2);
        n1.setRight(n3);

        n2.setRight(n4);
        n3.setLeft(n5);

        n4.setLeft(n6);

        n6.setLeft(n7);

        RightViewBFS lbfs = new RightViewBFS();
        List<Integer> retVal = lbfs.getRightView(n1);
        System.out.println(retVal);

        RightViewRec lfr = new RightViewRec();
        List<Integer> l = new ArrayList<>();
        lfr.getRightView(n1, 1 , l);
        System.out.println(l);


    }

    /**
     *
     *                 1
     *          2           3
     *
     *              4   5
     *
     *          6
     *
     *        7
     */
}
