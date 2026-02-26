class Solution {
    public int ways(int ind,int buy,int[] prices,int n,int profit,int[][] dp){
        if(ind>=n) return 0;
        if(dp[ind][buy]!=0){
            return dp[ind][buy];
        }
        if(buy==1){
            profit=Math.max(-prices[ind]+ways(ind+1,0,prices,n,profit,dp),ways(ind+1,1,prices,n,profit,dp));
        }
        else{
            profit=Math.max(prices[ind]+ways(ind+2,1,prices,n,profit,dp),ways(ind+1,0,prices,n,profit,dp));
        }
        dp[ind][buy]=profit;
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int[][] dp=new int[n+1][2];
        return ways(0,1,prices,n,profit,dp);
    }
}