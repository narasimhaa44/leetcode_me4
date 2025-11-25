class Solution {
    public boolean ways(int n,int target,int[] nums){
        if(target==0){
            return true;
        }
        if(n<0){
            return false;
        }
        boolean notpick=ways(n-1,target,nums);
        boolean pick=false;
        if(target>=nums[n]){
            pick=ways(n-1,target-nums[n],nums);
        }
        return pick || notpick;


    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        return ways(n-1,target,nums);
    }
}