package com.gdpr.graphs;

import java.util.*;

public class TopologicalSortDFS {
    static void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] vis){
        vis[i] = true;
        for(Integer curr : adj.get(i)){
            if(!vis[curr]){
                dfs(curr,adj,stack,vis);
            }

        }
        stack.push(i);
    }
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack();

        for(int i=0;i<V;i++){
            if(!vis[i])
                dfs(i,adj,stack,vis);
        }
        int[] res = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;

    }

}
