package com.roshan.tree.view.bottom;

import com.roshan.tree.Node;
import com.roshan.tree.view.top.TopViewRec;

public class BottomViewTest {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n7 = new Node(7);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);


        n1.setLeft(n2);
        n1.setRight(n3);

        n2.setLeft(n11);
        n2.setRight(n4);

        n3.setRight(n7);

        n4.setRight(n5);

        n11.setRight(n12);
        n12.setRight(n13);

        BottomViewBFS tvbfs = new BottomViewBFS();
        System.out.println(tvbfs.getBottomView(n1));

        BottomViewRec tvr = new BottomViewRec();
        System.out.println(tvr.getBottomView(n1));


    }
}
