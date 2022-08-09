package com.roshan.graph.topological.sort;

import com.roshan.graph.digraph.DirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnTopologicalSort {

    private DirectedGraph dg;

    public KahnTopologicalSort(DirectedGraph dg) {
        super();
        this.dg = dg;
    }


    public List<Integer> getTopologicalSort(){

        int size = dg.getNumOfVertex();
        int[] inDegree = new int[size];

        for(int i = 0;i< size ; i++){
            for(Integer adj:dg.getAdjacent(i)){
                inDegree[adj] = inDegree[adj]+1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<size;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }


        List<Integer> topologicalSort = new ArrayList<>();
        int currIndex = 0;

        while(!queue.isEmpty()){
            Integer elem = queue.poll();
            topologicalSort.add(elem);
            currIndex++;

            for(int adj:dg.getAdjacent(elem)){
                inDegree[adj] = inDegree[adj]-1;
                if(inDegree[adj] == 0){
                    queue.add(adj);
                }
            }
        }

        //means there is a cycle
        if(currIndex != size){
            return null;
        }

        return topologicalSort;

    }

    //main
    public static void main(String[] args) {

        DirectedGraph dg = new DirectedGraph(6);
        dg.addEdge(5, 2);
        dg.addEdge(5, 0);
        dg.addEdge(4, 0);
        dg.addEdge(4, 1);
        dg.addEdge(2, 3);
        dg.addEdge(3, 1);

        //add this to form cycle
        dg.addEdge(3, 5);

        KahnTopologicalSort tsSort = new KahnTopologicalSort(dg);
        System.out.println(tsSort.getTopologicalSort());
    }
}
