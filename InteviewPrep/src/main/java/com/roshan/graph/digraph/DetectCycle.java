package com.roshan.graph.digraph;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

	private DirectedGraph dg;

	public DetectCycle(DirectedGraph dg) {
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
}
