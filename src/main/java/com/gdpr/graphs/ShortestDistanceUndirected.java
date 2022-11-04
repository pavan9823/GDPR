package com.gdpr.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceUndirected {
    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        int[] dis = new int[n];
        for(int i=0;i<dis.length;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int curr : adj.get(node)){
                if(dis[node]+1<dis[curr]){
                    dis[curr]=dis[node]+1;
                    q.add(curr);
                }
            }
        }
        for(int i=0;i<dis.length;i++){
            if(dis[i] ==Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,3},{3,4},{4 ,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int m = 10;
        int n =9;
        int src =0;
        int res[] = shortestPath(edges,n,m,src);
        for (int i = 0; i < res.length ; i++) {
            System.out.print(res[i]+" ");
        }
    }
























}
