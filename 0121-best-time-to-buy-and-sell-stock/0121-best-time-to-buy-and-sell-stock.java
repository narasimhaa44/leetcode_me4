class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        // BRUTE Force
        int max=0;
        int mini=prices[0];
        // for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                int cost=prices[j]-mini;
                max=Math.max(max,cost);
                mini=Math.min(mini,prices[j]);
        //             max=prices[j]-prices[i];
        //         }
            }
        // }
        return max;
    }
}