package com.gdpr.graphs;

import com.gdpr.util.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTree_MST {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        // Add your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->x.f-y.f);
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0,0));
        int sum =0;
        while(!pq.isEmpty()){
            Pair pp = pq.remove();
            int wt = pp.f;
            int node = pp.s;
            if(vis[node])
                continue;
            vis[node] = true;
            sum+=wt;
            for(int i=0;i<adj.get(node).size();i++){
                int currWt = adj.get(node).get(i).get(1);
                int currNode = adj.get(node).get(i).get(0);
                if(!vis[currNode])
                    pq.add(new Pair(currWt,currNode));
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        
        adj.get(0).add(new ArrayList<>());
        adj.get(0).add(new ArrayList<>());
        adj.get(0).get(0).add(1);
        adj.get(0).get(0).add(5);
        adj.get(0).get(1).add(2);
        adj.get(0).get(1).add(1);

        adj.get(1).add(new ArrayList<>());
        adj.get(1).add(new ArrayList<>());
        adj.get(1).get(0).add(0);
        adj.get(1).get(0).add(5);
        adj.get(1).get(1).add(2);
        adj.get(1).get(1).add(3);

        adj.get(2).add(new ArrayList<>());
        adj.get(2).add(new ArrayList<>());
        adj.get(2).get(0).add(1);
        adj.get(2).get(0).add(3);
        adj.get(2).get(1).add(0);
        adj.get(2).get(1).add(5);



        
        int res = spanningTree(V,adj);
        System.out.println(res);
    }


}
