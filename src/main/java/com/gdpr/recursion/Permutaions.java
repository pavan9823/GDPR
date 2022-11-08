package com.gdpr.recursion;

import java.util.*;

public class Permutaions {
    public static void permute(String s, List<String> list, List<List<String>> res , boolean[] vis, int ind){
        if(s.length()==list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!vis[i]){
                vis[i] = true;
                list.add(s.charAt(i)+"");
                permute(s,list,res,vis,i);
                list.remove(list.size()-1);
                vis[i] = false;

            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> res = permutate("abc");
        System.out.println(res);
        List<String> list = new ArrayList<>();
        for(int i=0;i<res.size();i++){
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<res.get(i).size();j++){
                sb.append(res.get(i).get(j));
            }
            list.add(sb.toString());
        }
        System.out.println(list);
    }

    private static List<List<String>> permutate(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        boolean[] vis = new boolean[s.length()];
        permute(s,list,res,vis,0);
        return res;
    }
}
