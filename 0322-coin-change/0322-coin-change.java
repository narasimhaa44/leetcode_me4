class Solution {
    public int ways(int idx,int[] a,int target,int[][] dp){
        if(idx==0){
            if(target%a[0]==0){
                return target/a[0];
            }
            else
                return (int)1e9;
        }
        if(dp[idx][target]!=0){
            return dp[idx][target];
        }
        int notpick=ways(idx-1,a,target,dp);
        int pick=(int)1e9;
        if(a[idx]<=target){
            pick=1+ways(idx,a,target-a[idx],dp);
        }
        dp[idx][target]=Math.min(pick,notpick);
        return dp[idx][target];
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        int ans = ways(coins.length - 1, coins, amount,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
}
