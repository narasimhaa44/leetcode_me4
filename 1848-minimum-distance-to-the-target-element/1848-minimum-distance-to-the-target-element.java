class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                // System.out.println(i);
                minsum=Math.min(minsum,Math.abs(i-start));
            }
        }
        return minsum;
    }
}