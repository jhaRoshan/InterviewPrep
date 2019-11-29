package com.roshan.graph.digraph;

import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {

	private int noOfVertex;
	private List<Integer> [] adj;
	
	@SuppressWarnings("unchecked")
	public DirectedGraph(int V) {
		this.noOfVertex = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();  
		}
	}
	
	
	public void addEdge(int source , int target) {
		adj[source].add(target);
	}
	
	public List<Integer> getAdjacent(int source) {
		return adj[source];
	}

	public int getNumOfVertex() {
		return noOfVertex;
	}

}
