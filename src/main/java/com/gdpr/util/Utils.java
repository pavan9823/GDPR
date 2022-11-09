package com.gdpr.util;

public class Utils {
    public static void main(String[] args) {
        String input = "[[1,2,3,4],[1,2],[3,4],[0,4],[]]";
        String input1 = "[[1,2],[2,3],[5],[0],[5],[],[]]";

        input = input.replace("[","{");
        input = input.replace("]","}");
        input1 = input1.replace("[","{");
        input1 = input1.replace("]","}");
        System.out.println(input);
        System.out.println(input1);
    }
}
