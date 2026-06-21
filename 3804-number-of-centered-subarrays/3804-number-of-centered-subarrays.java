// 
class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            int subsum = 0;
            HashSet<Integer> subnums = new HashSet<>();
            for (int j = i; j < n; j++) {
                subsum += nums[j];
                subnums.add(nums[j]);
                result += subnums.contains(subsum) ? 1 : 0;
            }
        }

        return result;
    }
}