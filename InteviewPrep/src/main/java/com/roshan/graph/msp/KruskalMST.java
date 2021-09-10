package com.roshan.graph.msp;

import com.roshan.graph.digraph.DirectedGraph;
import com.roshan.graph.weigth.graph.Edge;
import com.roshan.graph.weigth.graph.EdgeWeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {

    private EdgeWeightedGraph ewg;
    private Queue<Edge> mst = new LinkedList<>();
    private double weight;

    public KruskalMST(EdgeWeightedGraph ewg) {
        super();
        this.ewg = ewg;

        PriorityQueue<Edge> minPQ = new PriorityQueue<>();
        for(Edge e:ewg.edges()){
            minPQ.add(e);
        }

        QuickFindUF uf = new QuickFindUF(ewg.getNumOfVertex());

        while(!minPQ.isEmpty() && mst.size() < ewg.getNumOfVertex()-1){
            Edge e = minPQ.poll();
            int v = e.either();
            int w = e.other(v);
            if(!uf.connected(v,w)){
                uf.union(v,w);
                mst.add(e);
                weight+=e.weight();
            }
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        return weight;
    }


    //main

    public static void main(String[] args){
        int V = 4;
        EdgeWeightedGraph graph = new EdgeWeightedGraph(V);
        graph.addEdge(new Edge(0,1,10));
        graph.addEdge(new Edge(0,2,6));
        graph.addEdge(new Edge(0,3,5));
        graph.addEdge(new Edge(1,3,15));
        graph.addEdge(new Edge(2,3,4));
        KruskalMST kmst = new KruskalMST(graph);
        System.out.println(kmst.edges());
        System.out.println(kmst.weight());
    }
}
