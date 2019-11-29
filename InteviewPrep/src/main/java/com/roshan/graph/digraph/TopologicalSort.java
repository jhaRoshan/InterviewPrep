package com.roshan.graph.digraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	private DirectedGraph dg;
	
	public TopologicalSort(DirectedGraph dg) {
		super();
		this.dg = dg;
	}



	public List<Integer> getTopologicalSort(){
		
		DetectCycle dc = new DetectCycle(dg);
		if(dc.hasCycle()) {
			return null;
		}
		
		int v = dg.getNumOfVertex();
		boolean[] visted = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i< v;i++) {
			if(!visted[i]) {
				topoUtil(i , visted ,stack);
			}
		}
		
		List<Integer> retVal = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			retVal.add(stack.pop());
		}
		
		return retVal;
	}

	private void topoUtil(int i, boolean[] visted, Stack<Integer> stack ) {
		visted[i]  =true;
		for(Integer e:dg.getAdjacent(i)) {
			if(!visted[e]) {
				topoUtil(e, visted, stack);
			}
		}
		stack.push(i);
	}
	
}
