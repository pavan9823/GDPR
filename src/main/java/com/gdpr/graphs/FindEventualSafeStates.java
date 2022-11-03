package com.gdpr.graphs;

import java.util.*;

public class FindEventualSafeStates {
    //A terminal node is always safe node
    //terminal node is something which has no outdegrees
    //a node is safe node if it leads to terminal node

        public static List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());

            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    //changing the direction of edges to apply Kahn's Algo
                    adjList.get(graph[i][j]).add(i);
                }
            }

            int[] indegree = new int[n];
            for (int i = 0; i < adjList.size(); i++) {
                for (int it : adjList.get(i)) {
                    indegree[it]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 0)
                    q.add(i);
            }
            List<Integer> safeNodes = new ArrayList<>();
            while (!q.isEmpty()) {
                int node = q.remove();
                safeNodes.add(node);
                for (int curr : adjList.get(node)) {
                    indegree[curr]--;
                    if (indegree[curr] == 0)
                        q.add(curr);
                }
            }
            Collections.sort(safeNodes);
            return safeNodes;
        }


    public static void main(String[] args) {
        /*
        {{1,2,3,4},{1,2},{3,4},{0,4},{}}
        {{1,2},{2,3},{5},{0},{5},{},{}}
         */
        int graph[][] = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> res = eventualSafeNodes(graph);
        System.out.println(res);
    }
}
