package com.gdpr.recursion;

public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        if(amount==0)
            return 1;
        int ans = 0;
        for(int i=0;i<coins.length;i++)
            if(amount-coins[i]>=0)
                ans+= change(amount-coins[i],coins);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(change(3,new int[]{1,2}));
    }
}
