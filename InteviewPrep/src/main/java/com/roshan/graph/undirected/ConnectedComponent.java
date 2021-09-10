package com.roshan.graph.undirected;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConnectedComponent {

    private boolean[] marked;
    private int[] id;
    private int count;



    public ConnectedComponent(Graph g){
        marked = new boolean[g.getNumOfVertex()];
        id = new int[g.getNumOfVertex()];
        for(int v = 0 ; v < g.getNumOfVertex() ; v++){
            if(!marked[v]){
                dfs(g, v);
                count++;
            }
        }
    }

    public int[] getIds(){
        return id.clone();
    }

    public boolean isConnected(int v, int w){
        return id[v] == id[w];
    }

    public int getNumOfConnectedComponent(){
        return this.count;
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w:g.getAdjacent(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }


}
