class Solution {
    public int ways(int ind,int buy,int[] prices,int profit,int[][] dp){
        if(ind==prices.length) return 0;
        if(buy==1){
            dp[ind][buy]=Math.max(-prices[ind]+ways(ind+1,0,prices,profit,dp),ways(ind+1,1,prices,profit,dp));
        }
        else{
            dp[ind][buy]=Math.max(prices[ind]+ways(ind+1,1,prices,profit,dp),ways(ind+1,0,prices,profit,dp));
        }
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        // return ways(0,1,prices,profit,dp);
        dp[n][0]=dp[n][1]=0;
        for(int ind=n-1;ind>=0;ind--){
            int profit=0;
            for(int buy=0;buy<=1;buy++){
            if(buy==1){
                     profit=Math.max(-prices[ind]+dp[ind+1][0],dp[ind+1][1]);
             }
            else{
                 profit=Math.max(prices[ind]+dp[ind+1][1],dp[ind+1][0]);
            }
            dp[ind][buy]=profit;
            }
        }
        return dp[0][1];
    }
}