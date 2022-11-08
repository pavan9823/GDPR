package com.gdpr.dp;

public class EditDistance {
    public static int recur(String s1, String s2, int i, int j){
        if(i==s1.length()){
            return j;
        }
        if(j==s2.length())
            return i;
        if( s1.charAt(i)==s2.charAt(j)){
            return recur(s1,s2,i+1,j+1);
        }
        int insert = 1+recur(s1,s2,i,j+1);
        int delete = 1+recur(s1,s2,i+1,j);
        int replace = 1+recur(s1,s2,i+1,j+1);

        return Math.min(insert,Math.min(delete,replace));
    }

    public static void main(String[] args) {
        int res = recur("horse","ros",0,0);
        System.out.println(res);
    }
}
