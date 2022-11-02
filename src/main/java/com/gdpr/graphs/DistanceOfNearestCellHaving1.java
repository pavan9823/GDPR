package com.gdpr.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int m = grid.length,n=grid[0].length;

        int[][] dist = new int[m][n];
        boolean vis[][] = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    Node node = new Node(i,j,0);
                    q.add(node);
                    vis[i][j]=true;
                }
            }
        }
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int d = q.peek().third;
            dist[row][col]=d;
            q.remove();
            for(int i=0;i<4;i++){
                int nRow = row+delRow[i];
                int nCol = col+delCol[i];

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    q.add(new Node(nRow,nCol,d+1));
                }

            }
        }

        return dist;

    }
}
class Node{
    int first;
    int second;
    int third;
    Node(int first,int second,int third){
        this.first = first;
        this.second=second;
        this.third=third;
    }
}
