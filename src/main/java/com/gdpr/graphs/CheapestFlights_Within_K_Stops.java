package com.gdpr.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class SingleTuple {
    int f;
    int s;
    int c;
    SingleTuple(int f, int s){
        this.f = f;
        this.s = s;
    }
    SingleTuple(int f, int s, int c){
        this(f,s);
        this.c = c;
    }

}

public class CheapestFlights_Within_K_Stops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<SingleTuple>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new SingleTuple(flights[i][1],flights[i][2]));
        }

        int[] dis = new int[n];
        for(int i=0;i<n;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;

        Queue<SingleTuple> q = new LinkedList<>();
        q.add(new SingleTuple(0,src,0));
        while(!q.isEmpty()){
            int stops = q.peek().f;
            int node = q.peek().s;
            int cost = q.peek().c;
            q.remove();
            if(stops>k) continue;
            for(SingleTuple p : adj.get(node)){
                int currNode = p.f;
                int currCost = p.s;
                if(cost+currCost<dis[currNode]){
                    dis[currNode] = cost+currCost;
                    q.add(new SingleTuple(stops+1,currNode,cost+currCost));
                }
            }
        }
        return (dis[dst]==Integer.MAX_VALUE)?-1:dis[dst];
    }


    public static void main(String[] args) {
        int n = 4;
        int[][] flight = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dest = 3;
        int k =1;
        int res = findCheapestPrice(n,flight,src,dest,k);
        System.out.println(res);
    }
}
