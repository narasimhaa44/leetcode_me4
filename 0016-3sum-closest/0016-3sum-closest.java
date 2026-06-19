import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++){

            int l = i + 1;
            int r = nums.length - 1;

            while(l < r){

                int sum = nums[i] + nums[l] + nums[r];

                // update closest
                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }

                if(sum < target){
                    l++;
                }
                else if(sum > target){
                    r--;
                }
                else{
                    return sum; // exact match
                }
            }
        }

        return closestSum;
    }
}