import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        int maxWindow = 1; 

        for (int j = 0; j < n; j++) {
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxWindow = Math.max(maxWindow, j - i + 1);
        }

        return n - maxWindow;
    }
}
