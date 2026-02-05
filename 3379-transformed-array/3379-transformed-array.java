// class Solution {
//     public int[] constructTransformedArray(int[] nums) {
//         int[] res=new int[nums.length];
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]>0){
//                 res[i]=nums[((i+Math.abs(nums[i]))%nums.length)];
//             }
//             else if(nums[i]<0){
//                 res[i]=nums[((Math.abs(nums[i])+i+nums.length)%nums.length)];
//             }
//             else{
//                 res[i]=nums[i];
//             }
//         }
//         return res;
//     }
// }
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int idx = ((i + nums[i]) % n + n) % n;
                res[i] = nums[idx];
            } else {
                res[i] = nums[i];
            }
        }
        return res;
    }
}

