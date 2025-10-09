class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;  // farthest index we can reach
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If current index is beyond the farthest reachable point, we can't move further
            if (i > reachable) return false;

            // Update the farthest reachable index
            reachable = Math.max(reachable, i + nums[i]);

            // If we can reach or pass the last index, no need to continue
            if (reachable >= n - 1) return true;
        }
        return true;
    }
}
