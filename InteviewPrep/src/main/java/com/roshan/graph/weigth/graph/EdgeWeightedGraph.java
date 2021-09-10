package com.roshan.graph.weigth.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {

    private final int v;
    private final List<Edge>[] adj;
    private List<Edge> edges = new ArrayList<>();

    public EdgeWeightedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }
    }


    public void addEdge(Edge e) {
        edges.add(e);
       int v = e.either();
       int w = e.other(v);
       adj[v].add(e);
       adj[w].add(e);
    }

    public List<Edge> getAdjacent(int source) {
        return adj[source];
    }

    public List<Edge> edges(){
        return edges;
    }

    public int getNumOfVertex() {
        return v;
    }
}
