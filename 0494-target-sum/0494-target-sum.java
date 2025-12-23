class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        if (totalSum < Math.abs(target)) return 0;
        if ((totalSum + target) % 2 != 0) return 0;

        int s1 = (totalSum + target) / 2;

        int[][] dp = new int[nums.length][s1 + 1];

        // Base case
        if (nums[0] == 0) {
            dp[0][0] = 2;  // +0 and -0
        } else {
            dp[0][0] = 1;
            if (nums[0] <= s1) dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int sum = 0; sum <= s1; sum++) {
                int notpick = dp[i - 1][sum];
                int pick = 0;
                if (nums[i] <= sum) {
                    pick = dp[i - 1][sum - nums[i]];
                }
                dp[i][sum] = pick + notpick;
            }
        }

        return dp[nums.length - 1][s1];
    }
}
