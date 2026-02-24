class Solution {
    public int ways(int ind,int buy,int[] prices,int cap,int profit,int n,int[][][] dp){
        if(cap==0) return 0;
        if(ind==n) return 0;
        if(dp[ind][buy][cap]!=0){
            return dp[ind][buy][cap];
        }
        if(buy==1){
            profit=Math.max(-prices[ind]+ways(ind+1,0,prices,cap,profit,n,dp),ways(ind+1,1,prices,cap,profit,n,dp));
        }
        else{
            profit=Math.max(prices[ind]+ways(ind+1,1,prices,cap-1,profit,n,dp),ways(ind+1,0,prices,cap,profit,n,dp));
        }
        dp[ind][buy][cap]=profit;
        return dp[ind][buy][cap];
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int[][][] dp=new int[n+1][2][3];
        // return ways(0,1,prices,2,profit,n,dp);
        // for(int i=0;i<=n;i++){
        //     for(int buy=0;buy<=1;buy++){
        //         dp[i][buy][0]=0;
        //     }
        // }
        // for(int buy=0;buy<=1;buy++){
        //     for(int cap=0;cap<=2;cap++){
        //         dp[n][buy][cap]=0;
        //     }
        // }
for(int i = n-1; i >= 0; i--){
    for(int buy = 0; buy <= 1; buy++){
        for(int cap = 1; cap <= 2; cap++){

            if(buy == 1){
                dp[i][buy][cap] = Math.max(
                    -prices[i] + dp[i+1][0][cap],
                    dp[i+1][1][cap]
                );
            }
            else{
                dp[i][buy][cap] = Math.max(
                    prices[i] + dp[i+1][1][cap-1],
                    dp[i+1][0][cap]
                );
            }

        }
    }
}
        return dp[0][1][2];
    }
}