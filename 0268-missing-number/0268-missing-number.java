import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int n : nums) {
            numbers.add(n); // boxing int → Integer
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!numbers.contains(i)) {
                return i;
            }
        }
        return -1; // just in case
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 0, 1};
        System.out.println(sol.missingNumber(nums)); // 2
    }
}
