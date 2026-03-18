class Solution {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums);
        int min=0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            min=i;
            for(int j=i;j<nums.length;j++){
                    if(nums[j]<=nums[min]){
                        min=j;
                    }
            }
            temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
        }
    }
}