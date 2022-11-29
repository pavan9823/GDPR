package com.amlc.high;

public class RaceCar {
    public static int racecar(int target) {
        int pos = 0;
        int speed = 1;
        return recur(target,0,pos,speed);
    }
    public static int recur(int target, int steps, int pos, int speed){
        if(target==pos)
            return steps;
        if(pos+speed<target){
            pos+=speed;
            speed*=2;
            return recur(target,steps+1,pos,speed);
        }
        else if(pos>target){
            speed = speed>0?speed-1:1;
            return recur(target,steps+1,pos,speed);
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(racecar(6));
    }
}
