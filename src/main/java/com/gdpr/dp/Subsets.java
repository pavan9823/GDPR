package com.gdpr.dp;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int target = 6;
//        System.out.println(subsets(arr,target));
        subTabulation(arr,target);
    }

    private static boolean subsets(int[] arr, int target) {
        Boolean[][] dp = new Boolean[arr.length][target+1];
        boolean res = subRecur(arr,target,arr.length-1,dp);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return res;
    }

    private static boolean subRecur(int[] arr, int target, int ind,Boolean[][] dp ) {
        if(target==0)
            return dp[ind][target] = true;
        if(ind==0)
            return dp[ind][target] = target==arr[ind];

        if(dp[ind][target]!=null)
            return dp[ind][target];

        boolean notPick = subRecur(arr,target,ind-1,dp);
        boolean pick = false;
        if(target>=arr[ind])
            pick = subRecur(arr,target-arr[ind],ind-1,dp);

        return dp[ind][target] = (pick || notPick);

    }
    public static void subTabulation(int[] arr, int k){
        boolean[][] dp = new boolean[arr.length][k+1];
        for(int ind=0;ind<arr.length;ind++)
            dp[ind][0] = true;
        for (int j = 0; j <= k; j++) {
            if(arr[0]<=j)
                dp[0][j-arr[0]]=true;
        }
        for(int ind=1;ind< arr.length;ind++){
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[ind-1][target]; //subRecur(arr,target,ind-1,dp);
                boolean pick = false;
                if(target>=arr[ind])
                    pick = dp[ind-1][target-arr[ind]]; //subRecur(arr,target-arr[ind],ind-1,dp);

                dp[ind][target] = (pick || notPick);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
