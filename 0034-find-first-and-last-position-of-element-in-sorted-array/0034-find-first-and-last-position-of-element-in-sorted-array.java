class Solution {
    // First occurrence of target
    public int firstIndex(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;

        int l = 0, r = n - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target)
                    ans = mid;      // store index
                r = mid - 1;       // move left
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    // Last occurrence of target
    public int lastIndex(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;

        int l = 0, r = n - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target)
                    ans = mid;      // store index
                l = mid + 1;       // move right
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            firstIndex(nums, target),
            lastIndex(nums, target)
        };
    }
}
