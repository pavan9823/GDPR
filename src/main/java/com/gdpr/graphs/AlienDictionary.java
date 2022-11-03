package com.gdpr.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
        public static String findOrder(String [] dict, int N, int K)
        {
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            for(int i=0;i<K;i++){
                adjList.add(new ArrayList<>());
            }
            for(int i=0;i<N-1;i++){
                String s1 = dict[i];
                String s2 = dict[i+1];
                int len = Math.min(s1.length(),s2.length());
                for(int j =0;j<len;j++){
                    //we are taking a,b,c,d as 0,1,2,3 so that it will be easy for us to create a graph with numbers
                    if(s1.charAt(j)!=s2.charAt(j)){
                        // for example s1=abce comes before s2=abcd so here in alien language 'e' comes before 'd' e->d
                        // we are subtracting with -a to get the number
                        adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                        //once found we should break it
                        break;
                    }
                }
            }
            //after getting the graph we can apply Kahn's algo to get the answer
            int[] topo = topologicalSort(adjList,K);
            String res = "";
            for(int i=0;i<topo.length;i++){
                //we are adding 'a' to ans since we have decreased it before
                res+=(char)((int)(topo[i]+'a'));
            }
            return res;
        }
        public static int[] topologicalSort(ArrayList<ArrayList<Integer>> adjList, int K){
            //Kahn's Algo
            int indegree[] = new int[K];
            for(int i=0;i<K;i++){
                for(int curr : adjList.get(i)){
                    indegree[curr]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<K;i++){
                if(indegree[i]==0)
                    q.add(i);
            }
            int t =0;
            int[] topo =new int[K];
            while(!q.isEmpty()){
                int node = q.remove();
                topo[t++] = node;
                for(int curr : adjList.get(node)){
                    indegree[curr]--;
                    if(indegree[curr]==0)
                        q.add(curr);
                }
            }
            return topo;
        }
    public static void main(String[] args) {
            String[] dict = {"baa","abcd","abca","cab","cad"};
            int K = 4;
            int N = 5;
            String res = findOrder(dict,N,K);
            System.out.println(res);
    }
}
