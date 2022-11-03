package com.roshan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P797AllPathFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> retVal  = new ArrayList<>();
        compute(graph , 0 , graph.length-1, new ArrayList<>() , retVal);
        return retVal;
    }

    private void compute(int[][] graph , int source , int dest, List<Integer> cPath , List<List<Integer>> retVal){

        cPath.add(source);
        if(source == dest){
            retVal.add(new ArrayList<>(cPath));
            return;
        }

        int[] adj = graph[source];
        for(int i = 0 ;i < adj.length ; i++){
            compute(graph, adj[i], dest, cPath, retVal);
            cPath.remove(cPath.size()-1);
        }

    }

    public static void main(String[] args) {
        int[][] graph =  {{4,3,1},{3,2,4},{3},{4},{}};
        P797AllPathFromSourceToTarget p = new P797AllPathFromSourceToTarget();
        System.out.println(p.allPathsSourceTarget(graph));
    }
}
