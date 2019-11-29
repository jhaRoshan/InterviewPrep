package com.roshan.graph.digraph;

public class DGTest {

	public static void main(String[] args) {
		
		DirectedGraph dg = new DirectedGraph(6);
		dg.addEdge(5, 2);
		dg.addEdge(5, 0);
		dg.addEdge(4, 0);
		dg.addEdge(4, 1);
		dg.addEdge(2, 3);
		dg.addEdge(3, 1);
		
		DetectCycle dc = new DetectCycle(dg);
		System.out.println(dc.hasCycle());
		
		TopologicalSort tsSort = new TopologicalSort(dg);
		System.out.println(tsSort.getTopologicalSort());
		
		
		
	}

}
