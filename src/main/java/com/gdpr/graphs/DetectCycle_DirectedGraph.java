package com.gdpr.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle_DirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        ArrayList<Integer> list  = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.remove();
            list.add(curr);
            for(int i : adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
        }

        return (list.size()==V)?false:true;


    }

    public static void main(String[] args) {

    }
}
