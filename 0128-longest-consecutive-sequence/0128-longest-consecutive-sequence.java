import java.util.Arrays;
class Solution {
    public int longestConsecutive(int[] nums) {
        // ArrayList<Integer> arr=new ArrayList<>();
        int cnt=1;
        int ans=1;
        if(nums.length==0) return 0;
        // for(int i=0;i<nums.length;i++){
        //     arr.add(nums[i]);
        // }
        // int[] dup=new int[nums.length];
        else if(nums.length>1){
        Arrays.sort(nums);
        for(int i=0,j=1;i<=nums.length-2 && j<=nums.length-1;i++,j++){
            if(nums[i]==nums[j]){
                // ans=Math.max(cnt,ans);
                continue;
            }
            else if(Math.abs(nums[i]-nums[j])==1){
                cnt++;
                ans=Math.max(cnt,ans);            
            }
            else{
                cnt=1;
            }
        }
        }
        return ans;
    }
}