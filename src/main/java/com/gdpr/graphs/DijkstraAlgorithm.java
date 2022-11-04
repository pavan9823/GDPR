package com.gdpr.graphs;

import java.util.*;

import com.gdpr.util.Pair;

public class DijkstraAlgorithm {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int[] parent = new int[n+1];
        int[] dist = new int[n+1];
        for (int i = 1; i <=n; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->y.f-x.f);
        pq.add(new Pair(1,0));

        while (!pq.isEmpty()){
            int node = pq.peek().f;
            int distance = pq.peek().s;
            pq.remove();

            for(Pair curr : adj.get(node)){
                int currDistance = curr.s;
                int currNode = curr.f;
                if(distance+currDistance < dist[currNode]){
                    dist[currNode] = distance+currDistance;
                    parent[currNode]=node;
                    pq.add(new Pair(currNode, distance+currDistance));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        if(dist[n]==1e9){
            list.add(-1);
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        int node = n;
        while (parent[node]!=node){
            stack.add(node);
            node = parent[node];
        }
        stack.add(1);
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
        int n = 5;
        int m = 6;
        List<Integer> res = shortestPath(n,m,edges);
        System.out.println(res);
    }

}