package com.roshan.inter.prep;

import com.roshan.graph.digraph.DirectedGraph;
import com.roshan.graph.msp.QuickFindUF;

import java.util.*;

public class Solution {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {


        DirectedGraph dg = new DirectedGraph(A+1);

        for(ArrayList<Integer> al: B){
            int u = al.get(0);
            int v = al.get(1);
            dg.addEdge(u,v);
        }


        if(isReachable(1,A,dg)){
            return 1;
        }
        return 0;
    }


        Boolean isReachable(int s, int d , DirectedGraph dg)
        {
            LinkedList<Integer> temp;

            boolean visited[] = new boolean[dg.getNumOfVertex()];

            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[s] = true;
            queue.add(s);

            Iterator<Integer> i;
            while (queue.size() != 0) {
                s = queue.poll();
                for (int n:dg.getAdjacent(s)) {

                    if (n == d)
                        return true;

                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            return false;
        }

    public static void main(String[] args){


        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<>();a1.add(1);a1.add(2);B.add(a1);
        ArrayList<Integer> a2 = new ArrayList<>();a2.add(2);a2.add(3);B.add(a2);
        ArrayList<Integer> a3 = new ArrayList<>();a3.add(4);a3.add(3);B.add(a3);
        Solution s = new Solution();
        System.out.println(s.solve(4,B));


//        ArrayList<Integer> a1 = new ArrayList<>();a1.add(1);a1.add(4);B.add(a1);
//        ArrayList<Integer> a2 = new ArrayList<>();a2.add(2);a2.add(1);B.add(a2);
//        ArrayList<Integer> a3 = new ArrayList<>();a3.add(4);a3.add(3);B.add(a3);
//        ArrayList<Integer> a4 = new ArrayList<>();a4.add(4);a4.add(5);B.add(a4);
//        ArrayList<Integer> a5 = new ArrayList<>();a5.add(2);a5.add(3);B.add(a5);
//        ArrayList<Integer> a6 = new ArrayList<>();a6.add(2);a6.add(4);B.add(a6);
//        ArrayList<Integer> a7 = new ArrayList<>();a7.add(1);a7.add(5);B.add(a7);
//        ArrayList<Integer> a8 = new ArrayList<>();a8.add(5);a8.add(3);B.add(a8);
//        ArrayList<Integer> a9 = new ArrayList<>();a9.add(2);a9.add(5);B.add(a9);
//        ArrayList<Integer> a10 = new ArrayList<>();a10.add(5);a10.add(1);B.add(a10);
//
//
//        ArrayList<Integer> a11 = new ArrayList<>();a11.add(4);a11.add(2);B.add(a11);
//        ArrayList<Integer> a12 = new ArrayList<>();a12.add(3);a12.add(1);B.add(a12);
//        ArrayList<Integer> a13 = new ArrayList<>();a13.add(5);a13.add(4);B.add(a13);
//        ArrayList<Integer> a14 = new ArrayList<>();a14.add(3);a14.add(4);B.add(a14);
//        ArrayList<Integer> a15 = new ArrayList<>();a15.add(1);a15.add(3);B.add(a15);
//        ArrayList<Integer> a16 = new ArrayList<>();a16.add(4);a16.add(1);B.add(a16);
//        ArrayList<Integer> a17 = new ArrayList<>();a17.add(3);a17.add(5);B.add(a17);
//        ArrayList<Integer> a18 = new ArrayList<>();a18.add(3);a18.add(2);B.add(a18);
//        ArrayList<Integer> a19 = new ArrayList<>();a19.add(5);a19.add(2);B.add(a19);



    }

}



