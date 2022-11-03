package com.gdpr.graphs;

import java.util.*;

public class ToplogicalSortBFS_KahnsAlgo {
    //Topological sort using BFS (Kahn's Algo)
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int curr : adj.get(i)){
                inDegree[curr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        int[] topo = new int[V];
        int t=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[t++] = node;
            //node is in your top sort
            //please remove it from in-degree
            for(int curr : adj.get(node)){
                inDegree[curr]--;
                if(inDegree[curr]==0)
                    q.add(curr);
            }

        }

        return topo;

    }

    public static void main(String[] args) {
//        topoSort()
    }
}
