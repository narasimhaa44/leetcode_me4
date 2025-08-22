class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxlen = 0;
        int currentLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentLen++;                  // increase streak
                maxlen = Math.max(maxlen, currentLen);
            } else {
                currentLen = 0;                // reset streak
            }
        }

        return maxlen;
    }
}