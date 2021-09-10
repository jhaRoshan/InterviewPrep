package com.roshan.graph.cycle;

import com.roshan.graph.digraph.DirectedGraph;
import com.roshan.graph.topological.sort.TopologicalSort;
import com.roshan.graph.weigth.graph.Edge;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/assign-directions-to-edges-so-that-the-directed-graph-remains-acyclic/
 */
public class AssignDirection {

    private DirectedGraph dg;

    public AssignDirection(DirectedGraph dg){
        this.dg = dg;
    }

    public List<Edge> getDirection( List<Edge> nonDirectedEdge){

        List<Edge> retVal = new ArrayList<>();
        TopologicalSort ts = new TopologicalSort(dg);
        List<Integer> tsort = ts.getTopologicalSort();

        for(Edge e:nonDirectedEdge){
            int u = e.either();
            int v = e.other(u);

            if(tsort.indexOf(u) < tsort.indexOf(v)){
                retVal.add(new Edge(u,v , 0));
            }else{
                retVal.add(new Edge(v,u , 0));
            }
        }
        System.out.println(retVal);
        return retVal;
    }


    //main

    public static void main(String[] args){
        DirectedGraph dg = new DirectedGraph(6);
        dg.addEdge(0,1);
        dg.addEdge(0,5);
        dg.addEdge(1,2);
        dg.addEdge(1,3);
        dg.addEdge(1,4);
        dg.addEdge(2,3);
        dg.addEdge(2,4);
        dg.addEdge(3,4);

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,2 , 0));
        edges.add(new Edge(0,3,0));
        edges.add(new Edge(4,5,0));

        AssignDirection ad = new AssignDirection(dg);
        ad.getDirection(edges);

    }


}
