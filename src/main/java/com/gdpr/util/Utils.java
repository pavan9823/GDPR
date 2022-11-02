package com.gdpr.util;

public class Utils {
    public static void main(String[] args) {
        String input = "[[0,1],[1,2],[2,0]]";
        input = input.replace("[","{");
        input = input.replace("]","}");
        System.out.println(input);
    }
}
