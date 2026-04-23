class Solution {
    public long[] distance(int[] nums) {
        long[] res=new long[nums.length];
       for(int i=0;i<nums.length;i++){
        int sum=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]==nums[j] && i!=j){
                sum+=Math.abs(i-j);
            }  
         }
         res[i]=sum;
       }
       return res; 
    }
}