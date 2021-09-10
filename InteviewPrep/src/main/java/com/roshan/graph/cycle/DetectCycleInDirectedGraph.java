package com.roshan.graph.cycle;

import com.roshan.graph.digraph.DirectedGraph;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInDirectedGraph {

	private DirectedGraph dg;

	public DetectCycleInDirectedGraph(DirectedGraph dg) {
		super();
		this.dg = dg;
	}
	
	public boolean hasCycle() {
		int v = dg.getNumOfVertex();
		Set<Integer> recTree = new HashSet<Integer>();
		boolean[] visited = new boolean[v];
		
		for(int i = 0; i< v;i++) {
			if(detectCycleUtil(i , visited , recTree)) {
				return true;
			}
		}

		return false;
		
	}

	private boolean detectCycleUtil(int i, boolean[] visited, Set<Integer> recTree) {

		if(recTree.contains(i)) {
			return true;
		}
		
		if(visited[i]) {
			return false;
		}
		
		recTree.add(i);
		visited[i]  =true;
		
		for (Integer v: dg.getAdjacent(i)) {
				if(detectCycleUtil(v, visited, recTree)) {
					return true;
				}
		}
		
		recTree.remove(i);
		
		return false;
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

		DetectCycleInDirectedGraph dc = new DetectCycleInDirectedGraph(dg);
		System.out.println(dc.hasCycle());



	}
}
