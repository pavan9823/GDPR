package com.gdpr.graphs;

import java.util.ArrayList;

public class Graph {

    // No. of vertices in graph
    private int v;

    // adjacency list
    private ArrayList<ArrayList<Integer>> adjList;

    // Constructor
    public Graph(int vertices) {

        // initialise vertex count
        this.v = vertices;

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v) {
        // Add v to u's list.
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
