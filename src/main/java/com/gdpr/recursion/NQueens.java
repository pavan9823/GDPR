package com.gdpr.recursion;

public class NQueens {

    public static void main(String[] args) {
        nQueens(4);
    }

    private static void nQueens(int n) {
        boolean[][] board = new boolean[n][n];
        recur(board,n,0);
    }

    private static void recur(boolean[][] board, int n, int j) {
        if(j==n){
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if(board[i][k]){
                        System.out.print("Q");
                    }else
                        System.out.print("-");
                }
                System.out.println();
            }
        }
        for (int i = 0; i < n; i++) {
            if(safe(board,i,j,n)){
                board[i][j] = true;
                recur(board,n,j+1);
                board[i][j] = false;
            }

        }
    }

    private static boolean safe(boolean[][] board, int i, int j,int n) {
        int row = i;
        int col = j;
    if(j==n)
        return false;
    while(i>=0 && j>=0){
            if(board[i][j])
                return false;
            i--;
            j--;

        }
        int dr = row;
        int dc = col;
        while(dc>=0){
            if(board[dr][dc])
                return false;
            dc--;
        }
        int ddr = row;
        int ddc = col;
        while(ddr<n && ddc>=0){
            if(board[ddr][ddc])
                return false;
            ddr++;
            ddc--;
        }
        return true;
    }
}
