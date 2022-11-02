package com.gdpr.graphs;

import java.util.*;

public class PathFromSrc2Dest {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        //Initializing graph with HashMap
        Map<Integer, List<Integer>> graph = new HashMap<>();

        //Add empty Lists to each Node
        for(int i=0;i<n;i++) graph.put(i,new ArrayList<>());

        //Traverse through the given edges and construct the graph
        for(int edge[] : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //visisted array to say if we have seen this value before
        boolean[] vis = new boolean[n];
        vis[source] =true;

        //since we chose bfs we will be using Queue Data structure
        //Intializing queue and added source to the queue
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        //run the while loop until q gets emptied
        //It is obvious that even after travelling from source to all paths
        // and If we can't get a path the we have to return false
        while(!q.isEmpty()){
            int curr = q.poll();

            //if the current value(removed valued from q) is equal to destination return true
            if(curr==destination)
                return true;

            //traverse through current value adjancency List and add it to the q
            // note only if the node is not visited
            for(int newNode : graph.get(curr)){
                if(!vis[newNode]){
                    vis[newNode] = true;
                    q.add(newNode);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0;
        int destination = 2;
        int n = 3;
        boolean valid = validPath(n,edges,source,destination);
        System.out.println(valid);
    }
}
