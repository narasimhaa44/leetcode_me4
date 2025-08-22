class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0; // position for next non-zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                if (i != pos) nums[i] = 0; // fill old place with 0
                pos++;
            }
        }
    }
}
