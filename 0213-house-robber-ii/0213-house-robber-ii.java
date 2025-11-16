class Solution {

    // Function to compute max sum of non-adjacent elements
    private int robLinear(int[] nums, int start, int end) {
        int prev = 0;      // dp[i-1]
        int prev2 = 0;     // dp[i-2]

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;

            int cur = Math.max(pick, notPick);

            prev2 = prev;
            prev = cur;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        // Only one house
        if (n == 1) return nums[0];

        // Case 1: exclude last house → from index 0 to n-2
        int ans1 = robLinear(nums, 0, n - 2);

        // Case 2: exclude first house → from index 1 to n-1
        int ans2 = robLinear(nums, 1, n - 1);

        return Math.max(ans1, ans2);
    }
}
