package com.roshan.graph.topological.sort;

import com.roshan.graph.cycle.DetectCycleInDirectedGraph;
import com.roshan.graph.digraph.DirectedGraph;

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
		
		DetectCycleInDirectedGraph dc = new DetectCycleInDirectedGraph(dg);
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




	//main
	public static void main(String[] args) {

		DirectedGraph dg = new DirectedGraph(6);
		dg.addEdge(5, 2);
		dg.addEdge(5, 0);
		dg.addEdge(4, 0);
		dg.addEdge(4, 1);
		dg.addEdge(2, 3);
		dg.addEdge(3, 1);

		TopologicalSort tsSort = new TopologicalSort(dg);
		System.out.println(tsSort.getTopologicalSort());
	}
}
