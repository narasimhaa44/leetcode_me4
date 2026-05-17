class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        double maxavg=-1e9;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }   
        maxavg=(double)sum/k;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            maxavg=Math.max(maxavg,(double)sum/k);
            // System.out.println(maxavg);
        }
        return maxavg;
    }
}