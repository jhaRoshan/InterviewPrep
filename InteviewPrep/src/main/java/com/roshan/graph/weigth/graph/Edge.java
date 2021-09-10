package com.roshan.graph.weigth.graph;

public class Edge implements Comparable<Edge>{

    private final int v,w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //either endpoint
    public int either(){
        return v;
    }

    //other endpoint
    public int other(int vertex){
        return vertex == v? w: v;
    }

    public double weight(){
        return weight;
    }

    @Override
    public int compareTo(Edge o) {
       if(this.weight > o.weight) return 1;
       else if(this.weight < o.weight) return -1;
       return 0;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
