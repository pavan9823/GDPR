package com.gdpr.graphs;

import java.util.*;
class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int wt;
    Edge(int src,int dest,int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    public int compareTo(Edge cmpEdge){
        return this.wt-cmpEdge.wt;
    }
}
public class KruskalsAlgo {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge tmp = new Edge(node,adjNode,wt);
                edges.add(tmp);
            }
        }
        Collections.sort(edges);
        int mstWt =0;
        DisjointSet ds = new DisjointSet(V);
        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            int wt = edges.get(i).wt;

            if(ds.findUParent(u)!=ds.findUParent(v)){
                mstWt+=wt;
                ds.unionBySize(u,v);
            }

        }
        return mstWt;
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
