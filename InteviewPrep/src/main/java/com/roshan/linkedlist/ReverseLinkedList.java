package com.roshan.linkedlist;

import com.roshan.linkedlist.core.Node;

public class ReverseLinkedList {


    private  static void reverseFromMid(Node root){

        Node top = root;
        int count = 0;
        while(root.next != null) {
            count = count +1;
            root = root.next;
        }

        Node mid = top , preMid = top;
        for(int i = 0 ; i<= count/2;i++){
            preMid = mid;
            mid = mid.next;
        }
        Node n = reverse(mid);
        preMid.next = n;
        print(top);
    }

    private static Node reverse(Node root) {
        Node prev = null;
        while(root != null){
            Node tmp = root.next;
            root.next = prev;
            prev = root;
            root = tmp;
        }
        return prev;
    }


    public static void print(Node root){
        System.out.println();
        while(root != null){
            System.out.print(root.data+" ");
            root = root.next;
        }
    }



    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

//       print(reverse(n1));
       reverseFromMid(n1);


    }



}
