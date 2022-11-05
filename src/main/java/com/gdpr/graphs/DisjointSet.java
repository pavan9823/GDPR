package com.gdpr.graphs;

import java.util.ArrayList;

public class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findUParent(int node){
        if(node == parent.get(node))
            return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ult_u = findUParent(u);
        int ult_v = findUParent(v);

        if(ult_u == ult_v) return;

        if(rank.get(ult_u)<rank.get(ult_v))
            parent.set(ult_u,ult_v);
        else if (rank.get(ult_u)>rank.get(ult_v))
            parent.set(ult_v,ult_u);
        else {
            parent.set(ult_v, ult_u);
            int rankU = rank.get(ult_u);
            rank.set(ult_u, rankU + 1);
        }
    }
    public void unionBySize(int u,int v){
        int ult_u = findUParent(u);
        int ult_v = findUParent(v);

        if(ult_u == ult_v) return;

        if(size.get(ult_u)<size.get(ult_v)){
            parent.set(ult_u,ult_v);
            size.set(ult_v,size.get(ult_u)+size.get(ult_v));
        }else{
            parent.set(ult_v,ult_u);
            size.set(ult_u,size.get(ult_u)+size.get(ult_v));
        }
    }


    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(5,6);
        ds.unionByRank(6,7);

        if(ds.findUParent(1) == ds.findUParent(7))
            System.out.println("same");
        else
            System.out.println("not same");
        ds.unionByRank(3,7);
        if(ds.findUParent(1) == ds.findUParent(7))
            System.out.println("same ");
        else
            System.out.println("not same");
    }
}
