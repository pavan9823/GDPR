package com.gdpr.recursion;

public class DiwaliLights {

    public static void main(String[] args) {
        int[] bulbs = {0,0,1,1,1,1,0,1};
//        System.out.println(bulbs.length-3);
        System.out.println(countConsecutiveLights(bulbs));
    }

    private static int countConsecutiveLights(int[] bulbs) {
        int ws  = 0,max =0,zeros=0,k=2;
        for (int we = 0; we < bulbs.length; we++) {
            if(bulbs[we]==0)
                zeros++;
            while(zeros>k){
                if(bulbs[ws]==0)
                    zeros--;
                ws ++;
            }
            max = Math.max(max,we-ws+1);
        }
        return max;
    }

}
