class Solution {

    public int mintime(int[] cost, int n, int[] dp) {
        if (n >= cost.length) return 0;     // reached beyond last step
        if (dp[n] != -1) return dp[n];
        int one = mintime(cost, n + 1, dp); // step of 1
        int two = mintime(cost, n + 2, dp); // step of 2

        return dp[n] = cost[n] + Math.min(one, two);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(mintime(cost, 0, dp), mintime(cost, 1, dp));
    }
}
