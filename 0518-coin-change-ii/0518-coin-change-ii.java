class Solution {
    public int ways(int ind,int target,int[] coins,int[][] dp){
        if(ind==0){
            if(target%coins[0]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[ind][target]!=0){
            return dp[ind][target];
        }
        int notpick=ways(ind-1,target,coins,dp);
        int pick=0;
        if(coins[ind]<=target){
            pick=ways(ind,target-coins[ind],coins,dp);
        }
        dp[ind][target]=pick+notpick;
        return dp[ind][target];
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        int ans=ways(coins.length-1,amount,coins,dp);
        return ans;
    }
}