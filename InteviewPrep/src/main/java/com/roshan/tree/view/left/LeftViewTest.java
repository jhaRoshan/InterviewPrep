package com.roshan.tree.view.left;

import com.roshan.tree.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeftViewTest {

    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.setLeft(n2);
        n1.setRight(n3);

        n2.setRight(n4);
        n3.setLeft(n5);
        n3.setRight(n6);
        n4.setLeft(n7);
        n5.setRight(n8);
        n6.setRight(n9);
        n9.setRight(n10);

        LeftViewBFS lbfs = new LeftViewBFS();
        List<Integer> retVal = lbfs.getLeftView(n1);
        System.out.println(retVal);

        LeftViewRec lfr = new LeftViewRec();
        List<Integer> l = new ArrayList<>();
        lfr.getLeftView(n1, 0 , new HashSet<>(), l);
        System.out.println(l);


    }

    /**
     *
     *                 1
     *          2           3
     *
     *              4   5       6
     *
     *          7           8        9
     *
     *                                 10
     */
}
